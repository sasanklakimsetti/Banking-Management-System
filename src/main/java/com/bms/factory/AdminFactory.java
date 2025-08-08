package com.bms.factory;

import com.bms.model.Admin;
import com.bms.model.Customer;
import com.bms.model.Role;
import com.bms.model.User;
import com.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Locale;
import java.util.UUID;

@Component
public class AdminFactory {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;
    public Admin createAdmin(String firstName, String lastName, String mobile, String email, String department){
        if(firstName.isEmpty()||firstName.trim().isEmpty()) throw new RuntimeException("First Name can't be empty.");
        if(lastName.isEmpty()||lastName.trim().isEmpty()) throw new RuntimeException("Last Name can't be empty.");
        if((mobile.isEmpty()||mobile.trim().length()<10)) throw  new RuntimeException("Mobile number should be provided.");
        if (email.isEmpty()||email.trim().isEmpty()) throw  new RuntimeException("Mail should be provided.");
        Admin admin=new Admin();
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setMobile(mobile);
        admin.setEmail(email);
        admin.setDepartment(department);

        // generating username and password for admin user
        String baseUsername = (firstName + lastName).trim().toLowerCase();
        String username = baseUsername;
        int counter = 1;
        while (userRepository.existsByUsername(username)) {
            username = baseUsername + counter;
            counter++;
        }

//        String username=(firstName+lastName).trim().toLowerCase();

        // system generate password is first five characters of first name + department + first five digits of mobile number
        String passwordPart1=firstName.length()>=5?firstName.substring(0,5).toLowerCase():firstName.toLowerCase();
        String passwordPart2=department.toLowerCase();
        String passwordPart3=mobile.substring(0,5);
        String randomSuffix = UUID.randomUUID().toString().substring(0,6);
        String password=passwordPart1+passwordPart2+passwordPart3+randomSuffix;

        User user=new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.ADMIN);
        User savedUser=userRepository.save(user);
        admin.setUser(savedUser);
        return admin;
    }
}
