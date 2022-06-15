package com.sinaukoding.abdl.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Object data;
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer row;
    HttpStatus httpStatus;

    public Response(String message, HttpStatus httpStatus){
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(Object object, String message, HttpStatus httpStatus){
        this.data = object;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public Response(Object data, String message, Integer row, HttpStatus httpStatus){
        this.data = data;
        this.message = message;
        this.row = row;
        this.httpStatus = httpStatus;
    }
}
