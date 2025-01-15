package com.vatsal.blog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
    private String message;
    private Boolean success;


    public ExceptionResponse(String message,Boolean success) {
        this.message = message;
        this.success = success;
    }


}
