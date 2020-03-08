package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table
@Entity(name="Account")
public class Account {


    @Id

    //  @NotBlank
    private int accountId;

    //   @NotBlank
    private String accountName;

    @NotBlank
    private String accountAddress;

    private String dateOpen;

    private String accountStatus;

    private String dateClosed;

    private String Email;

    private  String mobileNumber;
    private  String accountType;

    public Account(int accountId,String accountName,String accountAddress,String dateOpen, String accountStatus,String dateClosed, String Email,String mobileNumber, String accountType) {
        super();
        //   this.user_id = user_id;
        this.accountId=accountId;
        this.accountName=accountName;
        this.accountAddress=accountAddress;
        this.dateOpen=dateOpen;
        this.dateClosed=dateClosed;
        this.accountStatus=accountStatus;
        this.Email=Email;
        this.mobileNumber=mobileNumber;
        this. accountType=accountType;

    }


    public Account() {
        super();
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public String getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(String dateOpen) {
        this.dateOpen = dateOpen;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getDateClosed() {
        return dateClosed;
    }

    public void setDateClosed(String dateClosed) {
        this.dateClosed = dateClosed;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
