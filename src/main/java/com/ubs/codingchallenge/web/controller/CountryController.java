package com.ubs.codingchallenge.web.controller;

import com.ubs.codingchallenge.web.model.CountryWrapper;
import com.ubs.codingchallenge.web.model.SubregionWrapper;
import com.ubs.codingchallenge.web.service.CountryService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/country", produces = {"application/json", "text/csv"})
@RestController
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping(value = "/region/{region}/biggest")
    public @ResponseBody
    CountryWrapper get10BiggestCountriesByRegion(@PathVariable String region) {
        return countryService.findTenBiggestCountriesByRegion(region);
    }

    @GetMapping(value = "/subregion/{subregion}/borders")
    public @ResponseBody
    CountryWrapper getCountriesBySubRegionContainingOver3Boardes(@PathVariable String subregion) {
        return countryService.findBySubregionContainingOver3Borders(subregion);
    }

    @GetMapping(value = "/subregion/{subregion}/population")
    public @ResponseBody
    SubregionWrapper getSubregionPopulation(@PathVariable String subregion) {
        return countryService.findSubregionPopulation(subregion);
    }

}
