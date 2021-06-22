package com.ubs.codingchallenge.serializer.csv;

import com.opencsv.CSVWriter;
import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.ubs.codingchallenge.web.dto.CountryDTO;

import java.util.List;

public class CountryCsvSerializer extends AbstractBeanField<CountryDTO, Integer> {

    @Override
    protected String convertToWrite(Object obj) {
        StringBuilder data = new StringBuilder();
        List<CountryDTO> countries =  (List<CountryDTO>)obj;
        data.append("[");
        countries.forEach(c -> data.append(c.getAlpha3Code()).append(CSVWriter.DEFAULT_SEPARATOR));
        data.replace(data.length() - 1, data.length() , "]");

        return data.length() == 1 ? "" : data.toString();
    }

    @Override
    protected Object convert(String s) {
        //TODO - Deserialize
        return null;
    }
}
