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
    private Long customerid;
    private String fname;
    private String lname;
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

    public Long getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Long customerid) {
        this.customerid = customerid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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

    public Customer(String fname, String lname, Date dob, String address, String mobile, String mail, String aadhar, String pan) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.address = address;
        this.mobile = mobile;
        this.mail = mail;
        this.aadhar = aadhar;
        this.pan = pan;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", mail='" + mail + '\'' +
                ", aadhar='" + aadhar + '\'' +
                ", pan='" + pan + '\'' +
                '}';
    }
}
