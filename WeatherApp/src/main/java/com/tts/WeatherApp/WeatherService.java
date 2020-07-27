package com.tts.WeatherApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${api_key}")
    private String apiKey;

    private ZipCodeRepository zipCodeRepository;

    @Autowired
    public WeatherService(ZipCodeRepository zipCodeRepository) {
        this.zipCodeRepository = zipCodeRepository;
    }

    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&appid=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();

        saveNewZipCode(zipCode);

        try {
            return restTemplate.getForObject(url, Response.class);
        } catch (HttpClientErrorException ex) {
            Response response = new Response();
            response.setName("error");
            return response;
        }
    }

    public ZipCode findByZipCode(String zipCode) {
        return zipCodeRepository.findByZipCode(zipCode);
    }
    

    public List<ZipCode> findAll() {
        return (List<ZipCode>) zipCodeRepository.findAll();
    }

    public void save(ZipCode zipCode) {
        zipCodeRepository.save(zipCode);
    }

    public String saveNewZipCode(String zipCode) {
        ZipCode z = new ZipCode();
        z.setZipCode(zipCode);
        zipCodeRepository.save(z);
        return "Saved";
    }
        
}