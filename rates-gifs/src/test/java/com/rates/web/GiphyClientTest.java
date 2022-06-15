package com.rates.web;

import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.get;

@WireMockTest
class GiphyClientTest {

    @Test
    void getGif(WireMockRuntimeInfo wmRuntimeInfo) {
        stubFor(get("https://api.giphy.com/v1/gifs/random?api_key=8mai4nZttJ2k96CMB1Ms5wIcNBvx83os&tag=rich&rating=pg-13")
                .willReturn(ok()));
    }
}