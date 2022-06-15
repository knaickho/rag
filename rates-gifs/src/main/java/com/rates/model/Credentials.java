package com.rates.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor(force = true)
@Component
public class Credentials {

    @Value("${app.mode}")
    private final String DISPLAY_MODE;

    /** OXR credentials */
    @Value("${oxr.id}")
    private final String OXR_API_ID;

    @Value("${oxr.url.historical}")
    private final String HISTORICAL_RATES_ENDPOINT;

    @Value("${oxr.url.latest}")
    private final String LATEST_RATES_ENDPOINT;

    @Value("${oxr.base}")
    private final String DEFAULT_BASE;

    @Value("${oxr.symbol}")
    private final String DEFAULT_SYMBOL;

    @Value("${oxr.timespan}")
    private final Integer TIME_SPAN;

    /** GIPHY credentials */
    @Value("${giphy.url.api}")
    private final String GIPHY_ENDPOINT;

    @Value("${giphy.id}")
    private final String GIPHY_API_ID;

    @Value("${giphy.rating}")
    private final String GIPHY_RATING;

    @Value("${giphy.type}")
    private final String GIPHY_TYPE;
}