package com.bms.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "account")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "accounttype")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(
            name = "account_seq",
            sequenceName = "account_sequence",
            allocationSize = 1,
            initialValue = 2600000
    )
    private Long accountnumber;
    @OneToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerid")
    private Customer customerid;
    protected Double balance;
    private Date creationdate;
    protected String accounttype;

    public Account() {
        this.creationdate=Date.valueOf(LocalDate.now());
        this.balance= (double) 0;
    }

    public Long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(Long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationdate;
    }

    public void setCreationDate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getAccountType() {
        return accounttype;
    }

    public void setAccountType(String accounttype) {
        this.accounttype = accounttype;
    }

    
    public void showAccountDetails() {
        System.out.println("Account{" +
                "Account No.: " + accountnumber +
                ", Customer Id: " + customerid +
                ", Balance: " + balance +
                ", Creation Date: " + creationdate +
                ", Account Type='" + accounttype + '\'' +
                '}');
    }

    void deposit(int amount){
        balance+=amount;
    }
}
