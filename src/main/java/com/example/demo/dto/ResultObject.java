package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultObject {
    private String message;
    private Object data;
    private Integer code;

    public ResultObject() {
    }
    public ResultObject(String message, Integer code, Object data) {
        this.message = message;
        this.data = data;
        this.code = code;
    }
}
