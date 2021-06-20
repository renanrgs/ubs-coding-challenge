package com.ubs.codingchallenge.service;

import com.ubs.codingchallenge.web.client.CountryClient;
import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateDTO;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public List<CountryDTO> findTenBiggestCountriesByRegion(String region) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = countries.stream()
                .filter(c -> c.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
        countries = getReverseSortedCountries(countries);
        return countries;
    }

//    @Override
//    public List<CountryDTO> findTenBiggestCountriesByRegion(String region) {
//        List<CountryDTO> countries = client.getCountriesByRegion(region);
//        fillCountryBorders(countries);
//        countries = getReverseSortedCountries(countries);
//        return countries;
//    }

    private List<CountryDTO> getReverseSortedCountries(List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> !ObjectUtils.isEmpty(c.getArea()))
                .sorted(Collections
                        .reverseOrder(comparingDouble(CountryDTO::getArea))).limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public List<CountryDTO> findBySubregionContainingOver3Boarders(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterBySubRegionAndBoardersAmount(subregion, countries);
        return countries;
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

    @Override
    public SubregionAggregateDTO findSubregionPopulation(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = countries.stream()
                .filter(countryDTO -> trimAllWhitespace(countryDTO.getSubregion()).equalsIgnoreCase(subregion))
                .collect(Collectors.toList());
        SubregionAggregateDTO subregionAggregateDTO = buildSubRegion(countries);
        calculateTotalPopulation(subregionAggregateDTO);
        return subregionAggregateDTO;
    }

    private SubregionAggregateDTO buildSubRegion(List<CountryDTO> countries) {
        SubregionAggregateDTO subregionAggregateDTO = SubregionAggregateDTO.builder()
                .countries(countries)
                .build();
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
