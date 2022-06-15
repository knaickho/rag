package com.rates.service;

import com.rates.data.RateRepository;
import com.rates.data.Repository;

import org.springframework.stereotype.Service;
import com.rates.model.StorableData;

import java.util.Map;


/** Data Service отвечает за хранение и выдачу ставок */

@Service
public class DataService {

    private final Repository RATE_REPOSITORY = RateRepository.get();

    public Map<String, StorableData> getRates() {
        return RATE_REPOSITORY.findAll();
    }

    public void retain(Map<String, StorableData>  map) {
        map.entrySet().forEach(RATE_REPOSITORY::save);
    }
}