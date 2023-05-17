
package com.example.serviceweb10;

        import com.example.serviceweb10.CountriesWs.CapitalCity;
        import com.example.serviceweb10.CountriesWs.CapitalCityResponse;
        import com.example.serviceweb10.CountriesWs.CountryCurrency;
        import com.example.serviceweb10.CountriesWs.CountryCurrencyResponse;
        import org.slf4j.Logger;
        import org.slf4j.LoggerFactory;
        import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
        import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public CapitalCityResponse getCapital(String countryIsoCode) {

        CapitalCity request = new CapitalCity();
        request.setSCountryISOCode(countryIsoCode);


        CapitalCityResponse response = (CapitalCityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/countryinfoservice.wso", request,
                        new SoapActionCallback(
                                "http://www.oorsprong.org/websamples.countryinfo/CapitalCity"));

        return response;
    }

    public CountryCurrencyResponse getCurrency(String countryIsoCode) {

        CountryCurrency request = new CountryCurrency();
        request.setSCountryISOCode(countryIsoCode);


        CountryCurrencyResponse response = (CountryCurrencyResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://webservices.oorsprong.org/websamples.countryinfo/countryinfoservice.wso", request,
                        new SoapActionCallback(
                                "http://www.oorsprong.org/websamples.countryinfo/CapitalCity"));

        return response;
    }

}
