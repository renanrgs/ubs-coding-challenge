package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.util.Bootstrap;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.model.CountryWrapper;
import com.ubs.codingchallenge.web.model.SubregionWrapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CountryServiceIT {

    @Autowired
    private CacheManager cacheManager;

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
        CountryWrapper countries = countryService.findBySubregionContainingOver3Borders(southamerica);

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

    @Test
    void givenRegionCountriesShouldBeCached() {
        //Given
        String region = "oceania";

        //When
        CountryWrapper countries = countryService.findTenBiggestCountriesByRegion(region);
        CountryWrapper cachedCountries = (CountryWrapper) getCache("biggest10", region, CountryWrapper.class);

        //Then
        assertThat(cachedCountries).isNotNull();
        assertThat(cachedCountries.getData()).containsExactlyElementsOf(countries.getData());
    }

    @Test
    void givenSubregionCountriesHavingOver3BordersShouldBeCached() {
        //Given
        String subregion = "southamerica";

        //When
        CountryWrapper wrapper = countryService.findBySubregionContainingOver3Borders(subregion);
        CountryWrapper cachedWrapper = (CountryWrapper)
                getCache("subregionOver3Borders", subregion, CountryWrapper.class);

        //Then
        assertThat(cachedWrapper).isNotNull();
        assertThat(cachedWrapper.getData()).containsExactlyInAnyOrderElementsOf(wrapper.getData());
    }

    @Test
    void givenSubregionCountriesShouldBeCached() {
        //Given
        String subregion = "southamerica";

        //When
        SubregionWrapper wrapper = countryService.findSubregionPopulation(subregion);
        SubregionWrapper cachedWrapper = (SubregionWrapper)
                getCache("subregionPopulation", subregion, SubregionWrapper.class);
        Long wrapperTotalPopulation = wrapper.getData().get(0).getTotalPopulation();
        Long cachedTotalPopulation = cachedWrapper.getData().get(0).getTotalPopulation();
        List<CountryDTO> countries = wrapper.getData().get(0).getCountries();
        List<CountryDTO> cachedCountries = cachedWrapper.getData().get(0).getCountries();

        //Then
        assertThat(cachedWrapper).isNotNull();
        assertThat(cachedCountries)
                .containsExactlyInAnyOrderElementsOf(countries);
        assertThat(cachedTotalPopulation).isEqualTo(wrapperTotalPopulation);
    }

    private Object getCache(String cacheName, String key, Class clazz) {
        return cacheManager.getCache(cacheName).get(key, clazz);
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> southAmericaCountriesProvider() {
        return Bootstrap.southAmericaCountriesProvider();
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> allSouthAmericaCountriesProvider() {
        return Bootstrap.allSouthAmericaCountriesProvider();
    }

    @SuppressWarnings("unused")
    private static Stream<Arguments> oceaniaCountriesProvider() {
        return Bootstrap.oceaniaCountriesProvider();
    }
}