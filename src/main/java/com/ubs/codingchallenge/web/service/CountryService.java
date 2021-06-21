package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.model.CountryListDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateListDTO;

public interface CountryService {
    CountryListDTO findTenBiggestCountriesByRegion(String region);
    CountryListDTO findBySubregionContainingOver3Boarders(String subregion);
    SubregionAggregateListDTO findSubregionPopulation(String subregion);
}
