package com.ubs.codingchallenge.web.client;

import com.ubs.codingchallenge.web.model.CountryDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "com.ubs", ignoreUnknownFields = false)
public class CountryClient {
    private static final String COUNTRY_API_V2 = "/rest/v2/region/";
    private static final String params = "?fields=name;capital;region;subregion;population;area;borders;alpha3Code";
    public static final String COUNTRY_ALL_API_V2 = "/rest/v2/all";

    private String apiHost;

    private final RestTemplate restTemplate;

    public CountryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public List<CountryDTO> getCountriesByRegion(String region) {
        ResponseEntity<CountryDTO[]> responseEntity = restTemplate
                .getForEntity(apiHost + COUNTRY_API_V2 + region + params, CountryDTO[].class);
        CountryDTO[] countries = responseEntity.getBody();
        return Arrays.asList(countries);
    }
    public List<CountryDTO> findAll() {
        ResponseEntity<CountryDTO[]> responseEntity = restTemplate
                .getForEntity(apiHost + COUNTRY_ALL_API_V2 + params, CountryDTO[].class);
        CountryDTO[] countries = responseEntity.getBody();
        return Arrays.asList(countries);
    }
}
