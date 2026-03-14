package com.klu.model;

import java.time.LocalDateTime;

public class ErrrorResponse {

    private LocalDateTime timestamp;
    private String message;
    private int statusCode;

    public ErrrorResponse(LocalDateTime timestamp, String message, int statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}