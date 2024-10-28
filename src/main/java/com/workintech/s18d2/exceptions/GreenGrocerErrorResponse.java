package com.workintech.s18d2.exceptions;

import org.springframework.http.HttpStatus;

public class GreenGrocerErrorResponse {
    private String message;
    private int status;
    private long timeStamps;

    public GreenGrocerErrorResponse(String message, HttpStatus status, long timeStamps) {
        this.message = message;
        this.status = status.value();
        this.timeStamps = timeStamps;
    }
}
