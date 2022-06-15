package com.rates.web;

import javafx.application.Application;
import javafx.stage.Stage;

/** Этот компонент открывает дефолтный системный веб-браузер для показа пользователю результата работы приложения */

public class Browser extends Application {

    public void browser(String url) {
        getHostServices().showDocument(url);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}