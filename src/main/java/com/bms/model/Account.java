package com.bms.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "accountType")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(
            name = "account_seq",
            sequenceName = "account_sequence",
            allocationSize = 1,
            initialValue = 2600000
    )
    private Long accountNumber;
    @OneToOne
    @JoinColumn(name = "customerid", referencedColumnName = "customerId", nullable = false)
    private Customer customerId;
    protected Double balance=0.0;
    private Date creationDate;

    public Account() {
        this.creationDate=Date.valueOf(LocalDate.now());
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    
    public void showAccountDetails() {
        System.out.println("Account{" +
                "Account No.: " + accountNumber +
                ", Customer Id: " + customerId +
                ", Balance: " + balance +
                ", Creation Date: " + creationDate +
                ", "+
                '}');
    }

    public void deposit(Double amount){
        balance+=amount;
    }
}
