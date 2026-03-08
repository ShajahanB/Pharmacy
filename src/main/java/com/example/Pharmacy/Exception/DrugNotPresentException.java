package com.example.Pharmacy.Exception;

public class DrugNotPresentException extends RuntimeException {


    private String message;


    public DrugNotPresentException(String message) {
        super(message);
        this.message = message;
    }
}
