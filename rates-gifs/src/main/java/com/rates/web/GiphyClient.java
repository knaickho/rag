package com.rates.web;

import com.rates.model.Gif;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/** Feign Client получает данные на https://giphy.com */

@FeignClient(name = "giphyClient", url = "${giphy.url.api}")
public interface GiphyClient {

    @GetMapping("{parameters}")
    Gif get(@PathVariable("parameters") String parameters);
}