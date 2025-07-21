package com.bms.service;

import com.bms.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    Customer createCustomer(Customer customer);
    void removeCustomer(Long customerId);
    Customer showCustomerDetails(Long customerId);
    Customer updateCustomer(Long customerId, Customer customer);
    List<Customer>getAllCustomers();
    Customer getCustomerByMobile(String mobile);
    Customer getCustomerByAadhar(String aadhar);
    Customer getCustomerByFName(String fName);
    Customer getCustomerByLName(String lName);
    Customer getCustomerByPan(String pan);
    List<Customer> getCustomersByAddress(String address);
    //List<Transaction>showTransactionRecords(Long customerId);
}
