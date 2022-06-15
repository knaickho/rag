package com.rates.web;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/** Перехватчик корректирует символы в адресе запроса на https://giphy.com/ */

@Configuration
public class GiphyInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.uri(template.path().replaceAll("%26", "&"));
    }
}