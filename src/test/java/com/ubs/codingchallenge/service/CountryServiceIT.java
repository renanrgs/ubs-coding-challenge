package com.ubs.codingchallenge.service;

import com.ubs.codingchallenge.web.model.CountryDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class CountryServiceIT {

    @Autowired
    private CountryService countryService;

    @Test
    void findTenBiggestCountriesByRegion() {
        List<CountryDTO> countries = countryService.findTenBiggestCountriesByRegion("Oceania");
        assertThat(countries.get(0).getName(), is("Australia"));
        assertThat(countries, hasSize(10));
    }

    @Test
    void findBySubregionContainingOver3Boarders() {
        List<CountryDTO> countries = countryService.findBySubregionContainingOver3Boarders("South America");
        assertThat(countries, notNullValue());
    }

    @Test
    void findSubregionPopulation() {
    }
}