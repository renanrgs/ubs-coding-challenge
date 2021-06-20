package com.ubs.codingchallenge.controller;

import com.ubs.codingchallenge.service.CountryService;
import com.ubs.codingchallenge.web.model.CountryDTO;
import com.ubs.codingchallenge.web.model.SubregionAggregateDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(value = "/api/v1/country", produces = {"application/json", "text/csv"})
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @GetMapping("/biggest/{region}")
    public List<CountryDTO> get10BiggestCountriesByRegion(@PathVariable String region){
        return countryService.findTenBiggestCountriesByRegion(region);
    }

    @GetMapping("/subregion/{subregion}")
    public List<CountryDTO> getCountriesBySubRegionContainingOver3Boardes(@PathVariable String subregion){
        return countryService.findBySubregionContainingOver3Boarders(subregion);
    }

    @GetMapping("/subregion/{subregion}/population")
    public SubregionAggregateDTO getSubregionPopulation(@PathVariable String subregion){
        return countryService.findSubregionPopulation(subregion);
    }

}
