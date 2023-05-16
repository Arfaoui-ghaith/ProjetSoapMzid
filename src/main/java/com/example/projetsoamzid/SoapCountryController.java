package com.example.projetsoamzid;

import com.example.ws.CountryWs.CountryFlag;
import com.example.ws.CountryWs.CountryFlagResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/soapCountry")
public class SoapCountryController {
    private final CountryClient countryClient;

    @Autowired
    public SoapCountryController(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @GetMapping("/flag/{isoCode}")
    @ResponseBody
    public String getCardType(@PathVariable String isoCode) {
        CountryFlagResponse response = countryClient.getCardType(isoCode);
        return response.getCountryFlagResult():
    }
}
