package com.rates.service;

import com.rates.model.Gif;
import com.rates.model.Rate;
import com.rates.model.StorableData;

import lombok.Data;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/** Model Service настраивает запросы для веб-сервиса и переадресует найденный результат для показа пользователю */

@Data
@Service
public class ModelService {

    private final DataService DATA_SERVICE;
    private final CredentialsService CREDENTIALS_SERVICE;
    private final IOService IO_SERVICE;

    /** MODELLING block */
    public Set<String> modelRatesRequest() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String apiId = "?app_id=" + getOxrApiId();
        String base = "&base=" + getDefaultBase();
        String symbol = "&symbols=" + getDefaultSymbols();
        int timeSpan = getTimeSpan();

        String newerEndpoint = getLatestRatesEndpoint() + apiId + base + symbol;

        String olderDate = LocalDate.now().minusDays(timeSpan).format(formatter);
        String olderEndpoint = getHistoricalRatesEndpoint().replace(":date", olderDate) + apiId + base + symbol;

        return new HashSet<>(Arrays.asList(olderEndpoint, newerEndpoint));
    }

    public String modelGifsRequest() {
        String type = getGiphyType();
        String apiId = "?api_key=" + getGiphyApiId();
        String rating = "rating=" + getRating();
        String tag = "tag=" + doMaths();
        return type + apiId + "&" + tag + "&" + rating;
    }

    /** CREDENTIALS SERVICE block */

    private String getLatestRatesEndpoint() {
        return CREDENTIALS_SERVICE.getLatestRatesEndpoint();
    }

    private String getHistoricalRatesEndpoint() {
        return CREDENTIALS_SERVICE.getHistoricalRatesEndpoint();
    }

    private String getOxrApiId() {
        return CREDENTIALS_SERVICE.getOxrApiId();
    }

    private String getDefaultBase() {
        return CREDENTIALS_SERVICE.getDefaultBase();
    }

    private String getDefaultSymbols() {
        return CREDENTIALS_SERVICE.getDefaultSymbols();
    }

    private String getGiphyType() {
        return CREDENTIALS_SERVICE.getGiphyType();
    }

    private int getTimeSpan() {
        return CREDENTIALS_SERVICE.getTimeSpan();
    }

    private String getGiphyApiId() {
        return CREDENTIALS_SERVICE.getGiphyIpId();
    }

    private String getRating() {
        return CREDENTIALS_SERVICE.getRating();
    }

    /**  IO SERVICE block */

    public void showGif(Gif gif) {
        IO_SERVICE.displayGif(gif);
    }

    public void displayRates(Map<String, StorableData> rates) {
        IO_SERVICE.displayRates(rates);
    }

    /** Internal helper methods */

    private String doMaths() {
        Map<Long, Double> map = new HashMap<>();
        Map<String, StorableData> anotherMap = DATA_SERVICE.getRates();

        anotherMap.forEach((key, val) -> {
            Rate rate = (Rate) val;
            long timestamp = rate.getTimestamp();
            int count = rate.getRates().values().size();
            double allRates = rate.getRates().values().stream().reduce(0.0, Double::sum, Double::sum);
            map.put(timestamp, allRates / count);
        });

        Map.Entry<Long, Double> olderRateTemp = map.entrySet().stream()
                .min((entry1, entry2) -> (int) (entry1.getKey() - entry2.getKey())).get();

        double olderRate = map.remove(olderRateTemp.getKey());
        double newerRate = map.values().stream().findFirst().get();

        return newerRate > olderRate ? "rich" : "broke";
    }
}