package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.model.CountryListDTO;

public interface CountryService {
    CountryListDTO findTenBiggestCountriesByRegion(String region);
    CountryListDTO findBySubregionContainingOver3Boarders(String subregion);
    CountryListDTO findSubregionPopulation(String subregion);
}
