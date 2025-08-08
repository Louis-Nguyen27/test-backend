package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultPageable {
    private String message;
    private Object data;
    private Integer code;
    private Integer currentPage;
    private Integer totalPage;

    public ResultPageable() {
    }

    public ResultPageable(String message, Integer code, Object data, Integer currentPage, Integer totalPage) {
        this.message = message;
        this.data = data;
        this.code = code;
        this.currentPage = currentPage;
        this.totalPage = totalPage;
    }
}
