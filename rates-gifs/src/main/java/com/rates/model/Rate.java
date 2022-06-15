package com.rates.model;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Rate implements StorableData {

    private final String disclaimer;

    private final String licence;

    private final Long timestamp;

    private final String base;

    private final Map<String, Double> rates = new HashMap<>();
}