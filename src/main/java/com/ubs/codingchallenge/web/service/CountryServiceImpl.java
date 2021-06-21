package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.client.CountryClient;
import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.CountryListDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateListDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingDouble;
import static org.springframework.util.StringUtils.trimAllWhitespace;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryClient client;

    public CountryServiceImpl(CountryClient client) {
        this.client = client;
    }

    @Override
    public CountryListDTO findTenBiggestCountriesByRegion(String region) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = countries.stream()
                .filter(c -> c.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
        countries = getReverseSortedCountries(countries);
        CountryListDTO countryListDTO = getCountryList(countries);
        return countryListDTO;
    }

    private List<CountryDTO> getReverseSortedCountries(List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> !ObjectUtils.isEmpty(c.getArea()))
                .sorted(Collections
                        .reverseOrder(comparingDouble(CountryDTO::getArea))).limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public CountryListDTO findBySubregionContainingOver3Boarders(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterBySubRegionAndBoardersAmount(subregion, countries);
        CountryListDTO countryListDTO = getCountryList(countries);
        return countryListDTO;
    }

    private CountryListDTO getCountryList(List<CountryDTO> countries) {
        CountryListDTO countryListDTO = new CountryListDTO();
        countryListDTO.setList(countries);
        return countryListDTO;
    }

    @Override
    public SubregionAggregateListDTO findSubregionPopulation(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = countries.stream()
                .filter(countryDTO -> trimAllWhitespace(countryDTO.getSubregion()).equalsIgnoreCase(subregion))
                .collect(Collectors.toList());
        SubregionAggregateDTO subregionAggregateDTO = buildSubRegion(countries);
        calculateTotalPopulation(subregionAggregateDTO);
        SubregionAggregateListDTO subregionAggregateListDTO = new SubregionAggregateListDTO();
        subregionAggregateListDTO.setList(Arrays.asList(subregionAggregateDTO));
        return subregionAggregateListDTO;
    }

    private List<CountryDTO> filterBySubRegionAndBoardersAmount(String subregion, List<CountryDTO> countries) {
        countries = countries.stream()
                .filter(countryDTO -> trimAllWhitespace(countryDTO.getSubregion()).equalsIgnoreCase(subregion) &&
                        countryDTO.getBorders().size() > 3).collect(Collectors.toList());
        return countries;
    }

    private void fillCountryBorders(List<CountryDTO> countries) {
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

    private SubregionAggregateDTO buildSubRegion(List<CountryDTO> countries) {
        SubregionAggregateDTO subregionAggregateDTO = new SubregionAggregateDTO();
        subregionAggregateDTO.setCountries(countries);
        return subregionAggregateDTO;
    }

    private void calculateTotalPopulation(SubregionAggregateDTO subregionAggregateDTO) {
        Long totalPopulation = subregionAggregateDTO.getCountries()
                .stream()
                .map(CountryDTO::getPopulation)
                .reduce(Long::sum).get();
        subregionAggregateDTO.setTotalPopulation(totalPopulation);
    }
}
