package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.util.TestUtil;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.model.CountryWrapper;
import com.ubs.codingchallenge.web.model.SubregionWrapper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class CountryServiceIT {

    @Autowired
    private CountryService countryService;

    @ParameterizedTest()
    @MethodSource("oceaniaCountriesProvider")
    void findTenBiggestCountriesByRegion(List<CountryDTO> expectedCountries) {
        //given
        String region = "oceania";

        //when
        CountryWrapper countries = countryService.findTenBiggestCountriesByRegion(region);

        //then
        assertThat(countries.getData()).hasSize(10);
        assertThat(countries.getData()).containsExactlyElementsOf(expectedCountries);
        assertThat(countries.getData()).containsSequence(expectedCountries);
    }

    @ParameterizedTest
    @MethodSource("southAmericaCountriesProvider")
    void findBySubregionContainingOver3Boarders(List<CountryDTO> expectedCountries) {
        //given
        String southamerica = "southamerica";

        //when
        CountryWrapper countries = countryService.findBySubregionContainingOver3Boarders(southamerica);

        //then
        assertThat(countries).isNotNull();
        assertThat(countries.getData()).hasSize(6);
        assertThat(countries.getData()).containsExactlyInAnyOrderElementsOf(expectedCountries);
    }

    @ParameterizedTest
    @MethodSource("allSouthAmericaCountriesProvider")
    void findSubregionPopulation(List<CountryDTO> expectedCountries) {
        //given
        String subregion = "southamerica";

        //when
        SubregionWrapper subregionWrapper = countryService.findSubregionPopulation(subregion);

        //then
        assertThat(subregionWrapper).isNotNull();
        assertThat(subregionWrapper.getData()).isNotNull();
        assertThat(subregionWrapper.getData().get(0)).isNotNull();
        assertThat(subregionWrapper.getData().get(0).getTotalPopulation()).isNotNull();
        assertThat(subregionWrapper.getData().get(0).getCountries())
                .containsExactlyInAnyOrderElementsOf(expectedCountries);
    }

    private static Stream<Arguments> southAmericaCountriesProvider() {
        return TestUtil.southAmericaCountriesProvider();
    }

    private static Stream<Arguments> allSouthAmericaCountriesProvider() {
        return TestUtil.allSouthAmericaCountriesProvider();
    }

    private static Stream<Arguments> oceaniaCountriesProvider() {
        return TestUtil.oceaniaCountriesProvider();
    }
}