package com.ubs.codingchallenge.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ubs.codingchallenge.web.model.CountryDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class CountryClientIT {

    @Autowired
    private CountryClient client;

    @BeforeEach
    void setUp() throws InterruptedException {
    }

    @Test
    void givenARegion_thenReturnCountryList() throws JsonProcessingException {
        List<CountryDTO> countries = client.getCountriesByRegion("Americas");
        assertThat(countries, notNullValue());
    }

    @Test
    void testFindAll(){
        List<CountryDTO> countries = client.findAll();
        assertThat(countries, notNullValue());
    }

}