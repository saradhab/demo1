package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table
@Entity(name="loan")
public class Loan {

    @Id
    //  @NotBlank
    private int loanId;
    private int userId;
    private int accountId;


    @NotBlank
    private String loanAmount;

    private String loanOpenDate;

    private String loanStatus;

    @NotBlank
    private String loanType;

    public Loan( int loanId,int accountId,int userId,String loanAmount,String loanType,String loanOpenDate,String loanStatus) {

        this.loanId=loanId;
        this.accountId=accountId;
        this.userId=userId;
        this.loanAmount=loanAmount;
        this.loanType=loanType;
        this.loanOpenDate=loanOpenDate;
        this.loanStatus=loanStatus;
    }


    public Loan() {
    }



    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLoanOpenDate() {
        return loanOpenDate;
    }

    public void setLoanOpenDate(String loanOpenDate) {
        this.loanOpenDate = loanOpenDate;
    }

    public String getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(String loanStatus) {
        this.loanStatus = loanStatus;
    }


}
