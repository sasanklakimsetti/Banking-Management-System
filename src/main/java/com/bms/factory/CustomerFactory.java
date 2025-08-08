package com.bms.factory;

import com.bms.model.Customer;
import com.bms.model.Role;
import com.bms.model.User;
import com.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Locale;

@Component
public class CustomerFactory {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    public Customer createCustomer(String fname, String lname, Date dob, String address, String mobile, String email, String aadhar, String pan){
        if(fname.isEmpty()||fname.trim().isEmpty()) throw new RuntimeException("First Name can't be empty.");
        if(lname.isEmpty()||lname.trim().isEmpty()) throw new RuntimeException("Last Name can't be empty.");
        if(dob==null) throw new RuntimeException("Date of birth can't be empty.");
        if(address.isEmpty()||address.trim().isEmpty()) throw new RuntimeException("Address can't be empty.");
        if((mobile.isEmpty() || mobile.trim().length() < 10) && (email.isEmpty() || email.trim().isEmpty())) throw  new RuntimeException("Either of the mobile number or mail should be provided.");
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

        // generating username and password for User
        String username=(fname+lname).toLowerCase();
        // system generated password is first five characters in fname + first five digits of mobile number
        String passwordPart1=fname.length()>=5?fname.substring(0,5).toLowerCase():fname.toLowerCase();
        String passwordPart2=mobile.substring(0,5);
        String password=passwordPart1+passwordPart2;

        // Creating User for Customer
        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.CUSTOMER);

        User savedUser=userRepository.save(user);
        customer.setUser(savedUser);
        return customer;
    }
}
