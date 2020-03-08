package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;



@Table
@Entity(name="account_transaction")
public class AccountTransaction {


    @Id

    //  @NotBlank
    private int accountId;


    //   @NotBlank
    private String transactionNumber;

    @NotBlank
    private String transactionDate;

    private String transactionAccount;

    private String transactionType;

    private String loanId;

    private String payeeId;

    private String accountBalence;


    public AccountTransaction(int accountId, String transactionNumber, String transactionAccount, String transactionDate, String transactionType, String loanId, String payeeId, String accountBalence) {
        super();

        this.accountId = accountId;
        this.transactionNumber = transactionNumber;
        this.transactionAccount = transactionAccount;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.loanId = loanId;
        this.payeeId = payeeId;
        this.accountBalence = accountBalence;
    }


    public AccountTransaction() {
        super();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionAccount() {
        return transactionAccount;
    }

    public void setTransactionAccount(String transactionAccount) {
        this.transactionAccount = transactionAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getAccountBalence() {
        return accountBalence;
    }

    public void setAccountBalence(String accountBalence) {
        this.accountBalence = accountBalence;
    }



}
