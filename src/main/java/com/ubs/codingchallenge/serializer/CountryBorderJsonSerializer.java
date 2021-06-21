package com.ubs.codingchallenge.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ubs.codingchallenge.web.dto.CountryDTO;

import java.io.IOException;
import java.util.List;

public class CountryBorderJsonSerializer extends JsonSerializer<List<CountryDTO>> {


    @Override
    public void serialize(List<CountryDTO> borders, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        for(int i = 0; i < borders.size(); i++){
            if(borders.get(i) != null)
                borders.set(i, buildBorder(borders, i));
        }
        jsonGenerator.writeObject(borders);
    }

    private CountryDTO buildBorder(List<CountryDTO> countries, int index) {
        CountryDTO copy = CountryDTO.builder()
                .borders(null)
                .alpha3Code(countries.get(index).getAlpha3Code())
                .area(countries.get(index).getArea())
                .capital(countries.get(index).getCapital())
                .name(countries.get(index).getName())
                .population(countries.get(index).getPopulation())
                .subregion(countries.get(index).getSubregion()).region(countries.get(index).getRegion())
                .build();
        return copy;
    }
}
