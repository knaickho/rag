package com.rates.web;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

@WireMockTest
class OxrClientTest {

    @Test
    void getRates(WireMockRuntimeInfo wmRuntimeInfo) {
        stubFor(get("https://openexchangerates.org/api/historical/2022-06-12.json?app_id=1d757a1ce11c4e0cbc508e0854112f78&base=USD&symbols=RUB")
                .willReturn(ok()));
    }
}