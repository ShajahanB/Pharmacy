package com.example.Pharmacy.Exception;

public class DrugAlreadyExistException  extends RuntimeException{

    private String message;


    public DrugAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }
}
