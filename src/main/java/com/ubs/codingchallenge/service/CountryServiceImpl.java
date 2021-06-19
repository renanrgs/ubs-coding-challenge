package com.ubs.codingchallenge.service;

import com.ubs.codingchallenge.web.client.CountryClient;
import com.ubs.codingchallenge.web.model.CountryDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryClient client;

    public CountryServiceImpl(CountryClient client) {
        this.client = client;
    }

    @Override
    public List<CountryDTO> findTenBiggestCountriesByRegion(String region) {
        List<CountryDTO> countries = client.getCountriesByRegion(region);
        fillCountryBoardes(countries);
        return getReverseSortedCountries(countries);
    }

    private List<CountryDTO> getReverseSortedCountries(List<CountryDTO> countries) {
        return countries.stream().sorted(Collections
                .reverseOrder(comparing(CountryDTO::getArea))).limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> findBySubregionContainingOver3Boarders(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBoardes(countries);
        countries = countries.stream()
                .filter(countryDTO -> countryDTO.getSubregion().equals(subregion) &&
                        countryDTO.getBorders().size() > 3).collect(Collectors.toList());
        return countries;
    }

    private void fillCountryBoardes(List<CountryDTO> countries) {
        final Map<String, CountryDTO> mapCountries = new HashMap<>();
        countries.forEach(c -> {
            mapCountries.put(c.getAlpha3Code(), c);
        });

        countries.forEach(c -> {
            if (!c.getBorders().isEmpty()) {
                for (int i = 0; i < c.getBorders().size(); i++) {
                    c.getBorders().set(i, mapCountries.get(c.getBorders().get(i).getAlpha3Code()));
                }
            }
        });
    }

    @Override
    public Long findSubregionPopulation(String subregion) {
        return null;
    }
}
