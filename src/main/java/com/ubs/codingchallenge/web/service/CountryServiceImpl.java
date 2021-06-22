package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.client.CountryClient;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import com.ubs.codingchallenge.web.dto.SubregionDTO;
import com.ubs.codingchallenge.web.model.CountryWrapper;
import com.ubs.codingchallenge.web.model.SubregionWrapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static java.util.Comparator.comparing;
import static org.springframework.util.ObjectUtils.isEmpty;
import static org.springframework.util.StringUtils.trimAllWhitespace;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryClient client;

    public CountryServiceImpl(CountryClient client) {
        this.client = client;
    }

    @Cacheable(cacheNames = "biggest10", key = "#region")
    @Override
    public CountryWrapper findTenBiggestCountriesByRegion(String region) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterByRegion(region, countries);
        countries = reverseSortByArea(countries);
        return wrap(countries);
    }

    @Cacheable(cacheNames = "subregionOver3Borders", key = "#subregion")
    @Override
    public CountryWrapper findBySubregionContainingOver3Borders(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterBySubRegionAndBordersAmount(subregion, countries);
        return wrap(countries);
    }

    @Cacheable(cacheNames = "subregionPopulation", key = "#subregion")
    @Override
    public SubregionWrapper findSubregionPopulation(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterBySubregion(subregion, countries);
        SubregionDTO subregionDTO = buildSubRegion(countries);
        calculateTotalPopulation(subregionDTO);
        SubregionWrapper subregionWrapper = new SubregionWrapper();
        subregionWrapper.setData(singletonList(subregionDTO));
        return subregionWrapper;
    }

    private List<CountryDTO> filterByRegion(String region, List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> c.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
    }

    private List<CountryDTO> reverseSortByArea(List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> !isEmpty(c.getArea()))
                .sorted(Collections
                        .reverseOrder(comparing(CountryDTO::getArea))).limit(10)
                .collect(Collectors.toList());
    }

    private List<CountryDTO> filterBySubregion(String subregion, List<CountryDTO> countries) {
        return countries.stream()
                .filter(country -> trimAllWhitespace(country.getSubregion()).equalsIgnoreCase(subregion))
                .collect(Collectors.toList());
    }

    private CountryWrapper wrap(List<CountryDTO> countries) {
        CountryWrapper countryWrapper = new CountryWrapper();
        countryWrapper.setData(countries);
        return countryWrapper;
    }

    private List<CountryDTO> filterBySubRegionAndBordersAmount(String subregion, List<CountryDTO> countries) {
        countries = countries.stream()
                .filter(countryDTO -> trimAllWhitespace(countryDTO.getSubregion()).equalsIgnoreCase(subregion) &&
                        countryDTO.getBorders().size() > 3).collect(Collectors.toList());
        return countries;
    }

    private void fillCountryBorders(List<CountryDTO> countries) {
        final Map<String, CountryDTO> mapCountries = new HashMap<>();
        countries.forEach(c -> mapCountries.put(c.getAlpha3Code(), c));

        countries.forEach(c -> {
            if (!isEmpty(c) && !c.getBorders().isEmpty()) {
                for (int i = 0; i < c.getBorders().size(); i++) {
                    c.getBorders().set(i, mapCountries.get(c.getBorders().get(i).getAlpha3Code()));
                }
            }
        });
    }

    private SubregionDTO buildSubRegion(List<CountryDTO> countries) {
        return SubregionDTO.builder().countries(countries).build();
    }

    private void calculateTotalPopulation(SubregionDTO subregionDTO) {
        Long totalPopulation = subregionDTO.getCountries()
                .stream()
                .map(CountryDTO::getPopulation)
                .reduce(Long::sum).orElse(0L);
        subregionDTO.setTotalPopulation(totalPopulation);
    }
}
