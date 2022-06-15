package com.rates.web;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ForwardToFetch {

    public static HttpURLConnection createConnection() throws IOException {
        URL url = new URL("http://localhost:8080/fetch/oxr");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");
        return connection;
    }

    public static int forwardToLocalHost() {
        int responseCode = 0;
        HttpURLConnection connection = null;
        try {
            connection = createConnection();
            responseCode = connection.getResponseCode();
        }
        catch (IOException e) {
            System.out.println("IOException caught at the exit");
        }
        finally {
            if (null != connection) connection.disconnect();
        }
        return responseCode;
    }
}