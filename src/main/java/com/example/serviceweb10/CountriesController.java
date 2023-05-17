package com.example.serviceweb10;

import com.example.serviceweb10.CountriesWs.CapitalCityResponse;
import com.example.serviceweb10.CountriesWs.CountryCurrency;
import com.example.serviceweb10.CountriesWs.CountryCurrencyResponse;
import com.example.serviceweb10.CountriesWs.TCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountriesController {
    private final CountryClient countryClient;

    @Autowired
    public CountriesController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @PostMapping("soap/countryCapital/{iso}")
    public String getCountry(@PathVariable String iso){
        CapitalCityResponse response = countryClient.getCapital(iso);
        return response.getCapitalCityResult();
    }

    @PostMapping("soap/countryCurrency/{iso}")
    public TCurrency getCurreecy(@PathVariable String iso){
        CountryCurrencyResponse response = countryClient.getCurrency(iso);
        return response.getCountryCurrencyResult();
    }
}
