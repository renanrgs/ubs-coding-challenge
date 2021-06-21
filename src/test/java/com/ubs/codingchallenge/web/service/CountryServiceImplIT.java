package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.util.TestUtil;
import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.CountryListDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateListDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class CountryServiceImplIT {

    @Autowired
    private CountryService countryService;

    @ParameterizedTest
    @MethodSource("oceaniaCountriesProvider")
    void findTenBiggestCountriesByRegion(List<CountryDTO> expectedCountries) {
        //given
        String region = "oceania";

        //when
        CountryListDTO countries
                = countryService.findTenBiggestCountriesByRegion(region);

        //then
        assertThat(countries.getList()).hasSize(10);
        assertThat(countries.getList()).containsSequence(expectedCountries);
        assertThat(countries.getList()).containsExactlyElementsOf(expectedCountries);
    }

    @ParameterizedTest
    @MethodSource("southAmericaCountriesProvider")
    void findBySubregionContainingOver3Boarders(List<CountryDTO> expectedCountries) {
        //given
        String southamerica = "southamerica";

        //when
        CountryListDTO countries = countryService.findBySubregionContainingOver3Boarders(southamerica);

        //then
        assertThat(countries).isNotNull();
        assertThat(countries.getList()).hasSize(6);
        assertThat(countries.getList()).containsExactlyInAnyOrderElementsOf(expectedCountries);
    }

    @Test
    void findSubregionPopulation() {
        SubregionAggregateListDTO subregionAggregateDTO = countryService.findSubregionPopulation("southamerica");
        assertThat(subregionAggregateDTO).isNotNull();
    }

    private static Stream<Arguments> southAmericaCountriesProvider(){
        return TestUtil.southAmericaCountriesProvider();
    }

    private static Stream<Arguments> oceaniaCountriesProvider(){
        return TestUtil.oceaniaCountriesProvider();
    }
}