package com.ubs.codingchallenge.web.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubregionAggregateDTO {
    private Long totalPopulation;
    private CountryListDTO countryListDTO;

    public SubregionAggregateDTO(CountryListDTO countryListDTO) {
        this.countryListDTO = countryListDTO;
    }
}
