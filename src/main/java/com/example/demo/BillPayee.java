package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Table
@Entity(name="bill_payee")
public class BillPayee {



    @Id

    //  @NotBlank
    private int payeeId;

    //   @NotBlank
    private int userId;

   // @NotBlank
    private String payeeAccountNumber;

    private String payeeAddress;

    private String payeePhone;



    public BillPayee(int payeeId,int userId,String payeeAccountNumber,String payeeAddress,String payeePhone) {
        super();

        this.payeeId=payeeId;
        this.userId=userId;
        this.payeeAccountNumber=payeeAccountNumber;
        this.payeeAddress=payeeAddress;
        this.payeePhone=payeePhone;


    }


    public BillPayee() {
        super();
    }

    public int getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(int payeeId) {
        this.payeeId = payeeId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }

    public String getPayeePhone() {
        return payeePhone;
    }

    public void setPayeePhone(String payeePhone) {
        this.payeePhone = payeePhone;
    }
}

