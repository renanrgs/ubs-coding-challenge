package com.ubs.codingchallenge.converter;

import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.ubs.codingchallenge.web.model.ResourceWrapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 *
 * @param <T> Main Dto to be shown in json response
 * @param <L> Dto Wrapper to handle stackoverflow exceptions
 */
@Component
public class CsvHttpMessageConverter<T, L extends ResourceWrapper<T>>
        extends AbstractHttpMessageConverter<L> {

    /**
     * Set text/csv as a supported media type
     */
    public CsvHttpMessageConverter () {
        super(new MediaType("text", "csv"));
    }

    /**
     * It checks if Wrapper used is compatible with Resource Wrapper
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports (Class<?> clazz) {
        return ResourceWrapper.class.isAssignableFrom(clazz);
    }

    @Override
    protected L readInternal (Class<? extends L> clazz, HttpInputMessage inputMessage)
            throws HttpMessageNotReadableException {
        //TODO - Deserialize
        return null;
    }

    /**
     * Take a Dto, serialize it and place it into response body
     * @param data Wrapper list containing the data list to be written
     * @param outputMessage Responsible for giving access to response properties
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void writeInternal (L data, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {

        HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(toBeanType(data.getClass().getGenericSuperclass()));

        OutputStreamWriter outputStream = new OutputStreamWriter(outputMessage.getBody());
        StatefulBeanToCsv<T> beanToCsv =
                new StatefulBeanToCsvBuilder(outputStream)

                        .withMappingStrategy(strategy)
                        .build();
        try {
            beanToCsv.write(data.getData());
            outputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converts generics to the actual type of the object passed
     * @param type
     * @return Actual type of object (CountryDTO or SubregionDTO)
     */
    @SuppressWarnings("unchecked")
    private Class<T> toBeanType (Type type) {
        return (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }
}

