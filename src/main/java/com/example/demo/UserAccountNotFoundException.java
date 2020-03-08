package com.example.demo;

public class UserAccountNotFoundException extends Exception {
    private int userId;
    private int accountId;

    public  UserAccountNotFoundException(int userId) {
        super(String.format("User Account not found with id : '%s'", userId));
    }
}