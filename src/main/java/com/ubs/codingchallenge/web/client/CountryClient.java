package com.ubs.codingchallenge.web.client;

import com.ubs.codingchallenge.web.dto.CountryDTO;
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

    private String apiHost;
    private String uri;
    private String params;

    private final RestTemplate restTemplate;

    public CountryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public List<CountryDTO> findAll() {
        ResponseEntity<CountryDTO[]> responseEntity = restTemplate
                .getForEntity(apiHost + uri + params, CountryDTO[].class);
        CountryDTO[] countries = responseEntity.getBody();
        return Arrays.asList(countries);
    }
}
