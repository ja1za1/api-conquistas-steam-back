package com.tsi.apisteam.service;


import org.springframework.stereotype.Service;

@Service
public class ValidationService {

    public boolean isValidCountry(String country){
        return country != null && country.matches("^[a-zA-Z]{2}$");
    }

    public boolean isValidAppId(String appid){
        return appid != null && appid.matches("\\d+");
    }
}
