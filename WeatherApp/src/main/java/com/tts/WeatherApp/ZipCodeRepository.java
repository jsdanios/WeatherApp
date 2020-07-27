package com.tts.WeatherApp;

import org.springframework.data.repository.CrudRepository;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
    ZipCode findByZipCode(String zipCode);
}