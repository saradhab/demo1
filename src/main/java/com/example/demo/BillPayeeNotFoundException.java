package com.example.demo;

public class BillPayeeNotFoundException extends Exception  {

    private int accountId;
    public  BillPayeeNotFoundException(int payeeId) {
        super(String.format("BillPayee not found with id : '%s'", payeeId));
    }
}