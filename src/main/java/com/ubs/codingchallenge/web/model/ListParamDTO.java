package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ListParamDTO<T> {

    @JsonValue
    private List<T> list;

    public List<T> getList () {
        return list;
    }

    public void setList (List<T> list) {
        this.list = list;
    }
}
