package com.ubs.codingchallenge.web.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubregionAggregateDTO {
    private Long totalPopulation;
    private List<CountryDTO> countries;
}
