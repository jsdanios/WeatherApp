package com.tts.WeatherApp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ZIPCODE")
public class ZipCode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="zipcode_id")
    private Long id;
    
    private String zipCode;

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}