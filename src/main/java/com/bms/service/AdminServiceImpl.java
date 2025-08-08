package com.bms.service;

import com.bms.factory.AdminFactory;
import com.bms.model.Admin;
import com.bms.model.User;
import com.bms.repository.AdminRepository;
import com.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AdminFactory adminFactory;
    @Autowired
    private UserRepository userRepository;
    @Override
    public Admin createAdmin(Admin admin) {
        Admin admin1=adminFactory.createAdmin(
                admin.getFirstName(),
                admin.getLastName(),
                admin.getMobile(),
                admin.getEmail(),
                admin.getDepartment()
        );

        if(admin1==null) throw new RuntimeException("Error in creating new admin");
        return adminRepository.save(admin1);
    }
}
