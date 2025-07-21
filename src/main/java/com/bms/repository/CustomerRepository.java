package com.bms.repository;

import com.bms.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByMobile(String mobile);

    Customer findByAadhar(String aadhar);

    Customer findByFName(String fname);

    Customer findByLName(String lname);

    Customer findByPan(String pan);

    List<Customer> findByAddress(String address);
}
