package com.rates.data;
import com.rates.model.StorableData;

import java.util.Map;

public interface Repository {
    Map<String, StorableData> findAll();
    void save(Map.Entry<String, StorableData> data);
}