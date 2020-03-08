package com.example.demo;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Table
@Entity(name="user_account")
public class UserAccount {

    @Id
    private int userId;
    private String accountId;


    public UserAccount(int userId, String accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    public UserAccount() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
}