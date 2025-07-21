package com.bms.factory;

import com.bms.model.Customer;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CustomerFactory {
    public Customer createCustomer(String fname, String lname, Date dob, String address, String mobile, String email, String aadhar, String pan){
        if(fname.isEmpty()||fname.trim().isEmpty()) throw new RuntimeException("First Name can't be empty.");
        if(lname.isEmpty()||lname.trim().isEmpty()) throw new RuntimeException("Last Name can't be empty.");
        if(dob==null) throw new RuntimeException("Date of birth can't be empty.");
        if(address.isEmpty()||address.trim().isEmpty()) throw new RuntimeException("Address can't be empty.");
        if((mobile.isEmpty()||mobile.trim().isEmpty())&&(email.isEmpty()||email.trim().isEmpty())) throw  new RuntimeException("Either of the mobile number or mail should be provided.");
        if (aadhar.isEmpty()||aadhar.trim().isEmpty()) throw new RuntimeException("Aadhar can't be empty.");
        if(!aadhar.matches("\\d+")) throw new RuntimeException("Aadhar should only have digits.");
        if(pan.isEmpty()||pan.trim().isEmpty()) throw new RuntimeException("PAN can't be empty.");
        Customer customer=new Customer();
        customer.setFirstName(fname);
        customer.setLastName(lname);
        customer.setDob(dob);
        customer.setAddress(address);
        customer.setMobile(mobile);
        customer.setMail(email);
        customer.setAadhar(aadhar);
        customer.setPan(pan);

        return customer;
    }
}
