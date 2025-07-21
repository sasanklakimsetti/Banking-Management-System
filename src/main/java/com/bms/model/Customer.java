package com.bms.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Date;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    @SequenceGenerator(
            name = "customer_seq",
            sequenceName = "customer_sequence",
            allocationSize = 1,
            initialValue = 2200000
    )
    private Long customerId;
    private String firstName;
    private String lastName;
    @NotNull
    @Column(nullable = false)
    private Date dob;
    private String address;
    private String mobile;
    private String mail;
    @NotNull
    @Column(nullable = false)
    private String aadhar;
    @NotNull
    @Column(nullable = false)
    private String pan;

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fName='" + firstName + '\'' +
                ", lName='" + lastName + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lName) {
        this.lastName = lName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Customer() {
    }

    public Customer(String fName, String lName, Date dob, String address, String mobile, String mail, String aadhar, String pan) {
        this.firstName = fName;
        this.lastName = lName;
        this.dob = dob;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
        this.aadhar = aadhar;
        this.pan = pan;
    }

}
