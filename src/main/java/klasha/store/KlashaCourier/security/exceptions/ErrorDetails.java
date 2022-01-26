package klasha.store.KlashaCourier.security.exceptions;//package com.project.yconnector.web.controller.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Calendar;
import java.util.List;

@Data
public class ErrorDetails {

    private String timestamp;

    private String message;

    private String error;

    private HttpStatus status;



    public ErrorDetails(HttpStatus status, String message, String errors, String timestamp) {
        super();
        this.message = message;
        this.timestamp = timestamp;
        this.error=errors;
        this.status =status;
    }

    public ErrorDetails(HttpStatus status, String message, String errors) {
        super();
        this.message = message;
        this.timestamp = Calendar.getInstance().getTime().toString();
        this.error=errors;
        this.status =status;
    }



    public ErrorDetails(HttpStatus status, String message, List<String> errors) {
        super();
        this.message = message;
        this.error=errors.get(0);
        this.status =status;
    }









}