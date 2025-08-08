package com.bms.service;

import com.bms.model.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin createAdmin(Admin admin);
}
