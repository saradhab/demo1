package com.example.demo;

public class LoanNotFoundException extends Exception  {

    private int accountId;
    public LoanNotFoundException(int loanId) {
        super(String.format("BillPayee not found with id : '%s'", loanId));
    }
}
