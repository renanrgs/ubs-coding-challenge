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

    /**
     * It Finds 10 biggest area countries by region in reverse order
     * @param region Region of the country
     * @return 10 biggest countries based on their area amount
     */
    @Cacheable(cacheNames = "biggest10", key = "#region")
    @Override
    public CountryWrapper findTenBiggestCountriesByRegion(String region) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterByRegion(region, countries);
        countries = reverseSortByArea(countries);
        return wrap(countries);
    }

    /**
     * It Finds all countries of a subregion having over 3 borders
     * @param subregion Countries Subregion
     * @return All countries from a subregion which have over 3 borders
     */
    @Cacheable(cacheNames = "subregionOver3Borders", key = "#subregion")
    @Override
    public CountryWrapper findBySubregionContainingOver3Borders(String subregion) {
        List<CountryDTO> countries = client.findAll();
        fillCountryBorders(countries);
        countries = filterBySubRegionAndBordersAmount(subregion, countries);
        return wrap(countries);
    }

    /**
     * It finds all countries of a subregion and the sum of their population
     * @param subregion Subregion
     * @return Object containing the total population of a subregion and all its countries
     */
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

    /**
     * Filter a list of countries by their region
     * @param region Country region
     * @param countries list of countries to be filtered
     * @return Countries of a determined region
     */
    private List<CountryDTO> filterByRegion(String region, List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> c.getRegion().equalsIgnoreCase(region))
                .collect(Collectors.toList());
    }

    /**
     * It reverse sorts a list of countries by the area amount (Biggest first) and returns the 10 biggest.
     * @param countries List of countries
     * @return 10 Biggest countries by area
     */
    private List<CountryDTO> reverseSortByArea(List<CountryDTO> countries) {
        return countries.stream()
                .filter(c -> !isEmpty(c.getArea()))
                .sorted(Collections
                        .reverseOrder(comparing(CountryDTO::getArea))).limit(10)
                .collect(Collectors.toList());
    }

    /**
     * It filters a list of countries by a subregion
     * @param subregion Country subregion
     * @param countries List of countries
     * @return
     */
    private List<CountryDTO> filterBySubregion(String subregion, List<CountryDTO> countries) {
        return countries.stream()
                .filter(country -> trimAllWhitespace(country.getSubregion()).equalsIgnoreCase(subregion))
                .collect(Collectors.toList());
    }

    /**
     * It wraps a list of countries into a Custom Wrapper Object
     * @param countries List of countries
     * @return Country Wrapper which contins the country list to be serialized
     */
    private CountryWrapper wrap(List<CountryDTO> countries) {
        CountryWrapper countryWrapper = new CountryWrapper();
        countryWrapper.setData(countries);
        return countryWrapper;
    }

    /**
     * It takes a list of countries and filter it by region and number of borders (having over 3 borders)
     * @param subregion Country Subregion
     * @param countries List of Countries
     * @return Countries of a Subregion javing over 3 borders
     */
    private List<CountryDTO> filterBySubRegionAndBordersAmount(String subregion, List<CountryDTO> countries) {
        countries = countries.stream()
                .filter(countryDTO -> trimAllWhitespace(countryDTO.getSubregion()).equalsIgnoreCase(subregion) &&
                        countryDTO.getBorders().size() > 3).collect(Collectors.toList());
        return countries;
    }

    /**
     * Fully fill country borders based on their alpha3Code
     * @param countries List of countries to be filled with borders
     */
    private void fillCountryBorders(List<CountryDTO> countries) {
        final Map<String, CountryDTO> mapCountries = new HashMap<>();
        countries.forEach(country -> mapCountries.put(country.getAlpha3Code(), country));

        countries.forEach(country -> {
            if (!isEmpty(country) && !country.getBorders().isEmpty()) {
                for (int i = 0; i < country.getBorders().size(); i++) {
                    country.getBorders().set(i, mapCountries.get(country.getBorders().get(i).getAlpha3Code()));
                }
            }
        });
    }

    private SubregionDTO buildSubRegion(List<CountryDTO> countries) {
        return SubregionDTO.builder().countries(countries).build();
    }

    /**
     * Sum up the total population a a subregion.
     * @param subregionDTO Countries Subregion
     */
    private void calculateTotalPopulation(SubregionDTO subregionDTO) {
        Long totalPopulation = subregionDTO.getCountries()
                .stream()
                .map(CountryDTO::getPopulation)
                .reduce(Long::sum).orElse(0L);
        subregionDTO.setTotalPopulation(totalPopulation);
    }
}
