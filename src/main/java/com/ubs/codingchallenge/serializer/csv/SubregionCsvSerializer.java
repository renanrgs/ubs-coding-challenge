package com.ubs.codingchallenge.serializer.csv;

import com.opencsv.bean.AbstractBeanField;
import com.ubs.codingchallenge.web.dto.CountryDTO;

import java.util.List;

public class SubregionCsvSerializer extends AbstractBeanField<CountryDTO, Long>{

    private static final String newLineChar = "\n";

    @Override
    protected Object convert(String s) {
        //TODO - Deserialize
        return null;
    }

    /**
     * Serialize nested field or collections
     * @param obj Field to be serialized
     * @return String containing the serialized data
     */
    @Override
    protected String convertToWrite(Object obj) {
        final StringBuilder data = new StringBuilder();
        List<CountryDTO> countries =  (List<CountryDTO>)obj;
        countries.forEach(country -> {
            data.append("Name;").append(country.getName()).append("|")
                    .append("Capital;").append(country.getCapital()).append("|")
                    .append("Alpha3Code;").append(country.getAlpha3Code()).append("|")
                    .append("Subregion;").append(country.getSubregion()).append("|")
                    .append("Region;").append(country.getRegion()).append("|")
                    .append("Area;").append(country.getArea()).append("|")
                    .append("Population;").append(country.getPopulation()).append("|").append(newLineChar);
            data.append('[');
            country.getBorders().forEach(border -> {
                data.append(border.getAlpha3Code()).append("|");
            });
            data.append(']');
        });

        return data.toString();
    }
}
