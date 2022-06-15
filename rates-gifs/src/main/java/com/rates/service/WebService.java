package com.rates.service;

import com.rates.model.Gif;
import com.rates.model.StorableData;
import com.rates.web.GiphyClient;
import com.rates.web.OxrClient;
import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.*;

@Data
@Service
public class WebService {

    private final OxrClient OXR_CLIENT;
    private final GiphyClient GIPHY_CLIENT;

    private final DataService DATA_SERVICE;
    private final ModelService MODEL_SERVICE;

    public void getFromOxr() {
        Set<String> endpoints = buildEndpoints();
        Map<String, StorableData> rates = new HashMap<>();
        endpoints.forEach(endpoint -> rates.put(endpoint, OXR_CLIENT.getRates(endpoint)));
        displayRates(rates);
        retainRates(rates);
    }

    public void getFromGiphy() {
        if (ratesReady()) {
            String endpoint = getGifEndpoint();
            Gif gif = GIPHY_CLIENT.get(endpoint);
            displayGif(gif);
        }
    }

    private String getGifEndpoint() {
        return MODEL_SERVICE.modelGifsRequest();
    }

    private Set<String> buildEndpoints() {
        return MODEL_SERVICE.modelRatesRequest();
    }

    private void displayRates(Map<String, StorableData> rates) {
        MODEL_SERVICE.displayRates(rates);
    }

    private void displayGif(Gif gif) {
        MODEL_SERVICE.showGif(gif);
    }

    private void retainRates(Map<String, StorableData> map) {
        DATA_SERVICE.retain(map);
    }

    private boolean ratesReady() {
        int numOfRates = (int) DATA_SERVICE.getRates().entrySet().stream()
                .filter(entry -> null != entry.getValue())
                .count();
        return numOfRates == 2;
    }
}