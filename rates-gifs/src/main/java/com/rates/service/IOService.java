package com.rates.service;

import com.rates.model.Gif;
import com.rates.model.StorableData;

import com.rates.web.Browser;
import lombok.Data;

import org.springframework.stereotype.Service;

import java.util.*;

/** InputOutput Service показывает пользователю результаты - ставки и gif */

@Data
@Service
public class IOService {

    private final DataService DATA_SERVICE;
    private final CredentialsService CREDENTIALS_SERVICE;

    public void displayRates(Map<String, StorableData> rates) {
        System.out.println(rates);
    }

    public void displayGif(Gif gif) {
        String mode = getDisplayMode();

        Map<String, Object> map = gif.getData();
        String url = (String) map.get("url");

        if (mode.equals("auto")) {
            new Browser().browser(url);
        }
        else System.out.println(url);
        System.exit(0);
    }

    private String getDisplayMode() {
        return CREDENTIALS_SERVICE.getDisplayMode();
    }
}