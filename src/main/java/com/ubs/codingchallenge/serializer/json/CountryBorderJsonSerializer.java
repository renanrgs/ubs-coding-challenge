package com.ubs.codingchallenge.serializer.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.ubs.codingchallenge.web.dto.CountryDTO;

import java.io.IOException;
import java.util.List;

public class CountryBorderJsonSerializer extends JsonSerializer<List<CountryDTO>> {

    /**
     * Serialize nested collections or objects to Json format. It takes all borders fields and set null
     * if they have been already processed.
     * @param borders borders of a country
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(List<CountryDTO> borders, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        for(int i = 0; i < borders.size(); i++){
            if(borders.get(i) != null)
                borders.set(i, buildBorder(borders, i));
        }
        jsonGenerator.writeObject(borders);
    }

    /**
     * Build a border with its borders field null. It avoids stackoverflow.
     * @param borders country borders
     * @param index index of current border
     * @return Borders list
     */
    private CountryDTO buildBorder(List<CountryDTO> borders, int index) {
        CountryDTO border = CountryDTO.builder()
                .borders(null)
                .alpha3Code(borders.get(index).getAlpha3Code())
                .area(borders.get(index).getArea())
                .capital(borders.get(index).getCapital())
                .name(borders.get(index).getName())
                .population(borders.get(index).getPopulation())
                .subregion(borders.get(index).getSubregion()).region(borders.get(index).getRegion())
                .build();
        return border;
    }
}
