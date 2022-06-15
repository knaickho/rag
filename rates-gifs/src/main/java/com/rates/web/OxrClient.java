package com.rates.web;

import com.rates.model.Rate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/** Feign Client получает данные на https://openexchangerates.org */

@FeignClient(name = "oxrClient", url = "${oxr.url.api}")
public interface OxrClient {

    @GetMapping("{parameters}")
    Rate getRates(@PathVariable("parameters") String parameters);

}