package com.ubs.codingchallenge.service;

import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findTenBiggestCountriesByRegion(String region);
    List<CountryDTO> findBySubregionContainingOver3Boarders(String subregion);
    SubregionAggregateDTO findSubregionPopulation(String subregion);
}
