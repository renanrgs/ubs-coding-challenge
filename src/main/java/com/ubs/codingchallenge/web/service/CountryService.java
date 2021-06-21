package com.ubs.codingchallenge.web.service;

import com.ubs.codingchallenge.web.model.CountryWrapper;
import com.ubs.codingchallenge.web.model.SubregionWrapper;

public interface CountryService {
    CountryWrapper findTenBiggestCountriesByRegion(String region);
    CountryWrapper findBySubregionContainingOver3Boarders(String subregion);
    SubregionWrapper findSubregionPopulation(String subregion);
}
