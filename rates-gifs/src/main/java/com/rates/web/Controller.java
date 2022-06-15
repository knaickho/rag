package com.rates.web;

import com.rates.service.WebService;
import lombok.Data;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Data
@Component
@RequestMapping("${local.url.fetch}")
@CrossOrigin(origins = "*")
public class Controller {

    private final WebService WEB_SERVICE;

    @GetMapping("oxr")
    public RedirectView getOxr() {
        WEB_SERVICE.getFromOxr();

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("gif");
        return redirectView;
    }

    @GetMapping("gif")
    public RedirectView getGiphy() {
        WEB_SERVICE.getFromGiphy();

        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("done");
        return redirectView;
    }
}