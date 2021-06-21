package com.ubs.codingchallenge.web.dto;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import com.ubs.codingchallenge.serializer.SubregionAggregateCsvSerializer;
import com.ubs.codingchallenge.web.dto.CountryDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubregionDTO implements Serializable {

    private static final long serialVersionUID = -3625620584270137839L;
    @CsvBindByName
    private Long totalPopulation;

    @CsvBindByName
    @CsvCustomBindByName(converter = SubregionAggregateCsvSerializer.class)
    private List<CountryDTO> countries;
}

