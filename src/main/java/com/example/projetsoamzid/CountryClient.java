package com.example.projetsoamzid;

import com.example.ws.CountryWs.CountryFlag;
import com.example.ws.CountryWs.CountryFlagResponse;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.slf4j.Logger;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public CountryFlagResponse getCardType(String isoCode) {
        CountryFlag req = new CountryFlag();
        req.setSCountryISOCode(isoCode);

        log.info("Requesting iso code for " + isoCode);

        CountryFlagResponse res = (CountryFlagResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/countryinfoservice.wso", req,
                        null);

        return res;
    }
}
