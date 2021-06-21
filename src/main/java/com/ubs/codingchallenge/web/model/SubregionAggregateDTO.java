package com.ubs.codingchallenge.web.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.ubs.codingchallenge.serializer.SubregionAggregateCsvSerializer;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubregionAggregateDTO {

    @CsvBindByName
    private Long totalPopulation;

    @CsvBindByName
    @CsvCustomBindByName(converter = SubregionAggregateCsvSerializer.class)
    private List<CountryDTO> countries;
}

