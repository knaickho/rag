package com.rates.service;

import com.rates.model.Credentials;

import lombok.Data;

import org.springframework.stereotype.Service;

/** Credentials Service выдаёт данные, прописанные в yml, для настройки запросов веб-сервисом */

@Data
@Service
public class CredentialsService {

    private final Credentials CREDENTIALS;

    public String getLatestRatesEndpoint() {
        return CREDENTIALS.getLATEST_RATES_ENDPOINT();
    }

    public String getHistoricalRatesEndpoint() {
        return CREDENTIALS.getHISTORICAL_RATES_ENDPOINT();
    }

    public String getOxrApiId() {
        return CREDENTIALS.getOXR_API_ID();
    }

    public String getDefaultBase() {
        return CREDENTIALS.getDEFAULT_BASE();
    }

    public String getDefaultSymbols() {
        return CREDENTIALS.getDEFAULT_SYMBOL();
    }

    public String getGiphyIpId() {
        return CREDENTIALS.getGIPHY_API_ID();
    }

    public String getRating() {
        return CREDENTIALS.getGIPHY_RATING();
    }

    public String getGiphyType() {
        return CREDENTIALS.getGIPHY_TYPE();
    }

    public int getTimeSpan() {
        return CREDENTIALS.getTIME_SPAN();
    }

    public String getDisplayMode() {
        return CREDENTIALS.getDISPLAY_MODE();
    }
}