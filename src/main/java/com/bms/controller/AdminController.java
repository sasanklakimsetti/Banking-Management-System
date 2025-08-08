package com.bms.controller;

import com.bms.factory.AdminFactory;
import com.bms.model.Admin;
import com.bms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminFactory adminFactory;

    @Autowired
    private AdminService adminService;
    @PostMapping("/create")
    public ResponseEntity<?> createAdmin(@RequestBody Admin admin){
        Admin admin1=adminService.createAdmin(admin);
        return new ResponseEntity<>(admin1, HttpStatus.OK);
    }
}
