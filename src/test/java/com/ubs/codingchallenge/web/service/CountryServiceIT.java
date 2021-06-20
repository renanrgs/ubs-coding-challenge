package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.model.CountryListDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class CountryServiceIT {

    @Autowired
    private CountryService countryService;

    @Test
    void findTenBiggestCountriesByRegion() {
/*        List<CountryDTO> countries = countryService.findTenBiggestCountriesByRegion("Oceania");
        assertThat(countries.get(0).getName(), is("Australia"));
        assertThat(countries, hasSize(10));*/
    }

    @Test
    void findBySubregionContainingOver3Boarders() {
        CountryListDTO countries = countryService.findBySubregionContainingOver3Boarders("southamerica");
        assertThat(countries, notNullValue());
    }

    @Test
    void findSubregionPopulation() {
        CountryListDTO subregionAggregateDTO = countryService.findSubregionPopulation("South America");
        assertThat(subregionAggregateDTO, notNullValue());
    }
}