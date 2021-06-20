package com.ubs.codingchallenge.web.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ListParamDTO<T> {

    @JsonUnwrapped
    private List<T> list;

    public List<T> getList () {
        return list;
    }

    public void setList (List<T> list) {
        this.list = list;
    }
}
