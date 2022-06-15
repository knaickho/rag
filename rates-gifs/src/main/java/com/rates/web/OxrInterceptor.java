package com.rates.web;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/** Перехватчик корректирует символы в адресе запроса на https://openexchangerates.org/ */

@Configuration
public class OxrInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.uri(template.path().replaceAll("%3D", "="));
        template.uri(template.path().replaceAll("%3F", "?"));
        template.uri(template.path().replaceAll("%26", "&="));
    }
}