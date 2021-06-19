package com.ubs.codingchallenge.service;

import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.RegionDTO;

import java.util.List;

public interface CountryService {
    List<CountryDTO> findTenBiggestCountriesByRegion(String region);
    List<CountryDTO> findBySubregionContainingOver3Boarders(String subregion);
    Long findSubregionPopulation(String subregion);
}
