package com.ubs.codingchallenge.web.controller;

import com.ubs.codingchallenge.web.model.SubregionAggregateListDTO;
import com.ubs.codingchallenge.web.service.CountryService;
import com.ubs.codingchallenge.web.model.CountryListDTO;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/country", produces = {"application/json", "text/csv"})
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/biggest/{region}")
    public @ResponseBody
    CountryListDTO get10BiggestCountriesByRegion(@PathVariable String region) {
        return countryService.findTenBiggestCountriesByRegion(region);
    }

    @GetMapping(value = "/subregion/{subregion}")
    public @ResponseBody CountryListDTO getCountriesBySubRegionContainingOver3Boardes(@PathVariable String subregion) {
        return countryService.findBySubregionContainingOver3Boarders(subregion);
    }

    @GetMapping(value = "/subregion/{subregion}/population")
    public @ResponseBody
    SubregionAggregateListDTO getSubregionPopulation(@PathVariable String subregion) {
        return countryService.findSubregionPopulation(subregion);
    }

}
