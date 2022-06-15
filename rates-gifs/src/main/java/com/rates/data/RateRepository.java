package com.rates.data;

import com.rates.model.StorableData;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/** Приложению не требуется сохранять данные после завершения работы. Тем не менее, репозиторий может быть переработан для долгосрочного хранения данных */

@Data
@Component
public class RateRepository implements Repository {

    private static volatile Repository repository;

    private Set<StorableData> RESULTS;

    private RateRepository() {}

    private final Map<String, StorableData> endpointAndRate = new ConcurrentHashMap<>();

    public static synchronized Repository get() {
        if (null == repository) repository = new RateRepository();
        return repository;
    }

    @Override
    public Map<String, StorableData> findAll() {
        return new HashMap<>(endpointAndRate);
    }

    @Override
    public void save(Map.Entry<String, StorableData> entry) {
        endpointAndRate.put(entry.getKey(), entry.getValue());
    }
}