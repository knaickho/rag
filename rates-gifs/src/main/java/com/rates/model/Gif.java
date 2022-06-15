package com.rates.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Data
@Setter
@NoArgsConstructor(force = true)
public class Gif {

    private final Map<String, Object> data = new HashMap<>();
    private final Map<String, Object> meta = new HashMap<>();

}