package com.tts.WeatherApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping(value="/zipcodes")
    public String getIndex(Model model) {
        List<ZipCode> zipCodes = weatherService.findAll();
        model.addAttribute("recent-searches-get", zipCodes);

        model.addAttribute("request", new Request());
        return "index";
    }

    @PostMapping
    public String postIndex(Request request, Model model) {
        List<ZipCode> zipCodes = weatherService.findAll();
        model.addAttribute("recent-searches-post", zipCodes);
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }
}