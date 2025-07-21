package com.bms.service;

import com.bms.factory.CustomerFactory;
import com.bms.model.Account;
import com.bms.model.Customer;
import com.bms.repository.AccountRepository;
import com.bms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerFactory customerFactory;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        Customer customer1=customerFactory.createCustomer(customer.getFirstName(), customer.getLastName(), customer.getDob(), customer.getAddress(), customer.getMobile(), customer.getMail(), customer.getAadhar(), customer.getPan());
        if (customer1==null) throw new RuntimeException("Error in creating new customer");
        return customerRepository.save(customer1);
    }

    @Override
    public void removeCustomer(Long customerId) {
        Customer customer=customerRepository.findById(customerId).orElse(null);
        if (customer==null) throw new RuntimeException("Customer not found with the id: "+ customerId);
        customerRepository.delete(customer);
    }

    @Override
    public Customer showCustomerDetails(Long customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        Customer customer1=customerRepository.findById(customerId)
                .orElseThrow(()->new RuntimeException("Customer not found with Id: "+customerId));
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setDob(customer.getDob());
        customer1.setAddress(customer.getAddress());
        customer1.setMobile(customer.getMobile());
        customer1.setMail(customer.getMail());
        customer1.setAadhar(customer.getAadhar());
        customer1.setPan(customer.getPan());
        return customerRepository.save(customer1);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerByCustomerId(Long customerId) {
        return customerRepository.findByCustomerId(customerId);
    }

    @Override
    public Customer getCustomerByMobile(String mobile) {
        return customerRepository.findByMobile(mobile);
    }

    @Override
    public Customer getCustomerByAadhar(String aadhar) {
        return customerRepository.findByAadhar(aadhar);
    }

    @Override
    public Customer getCustomerByFName(String firstName) {
        return customerRepository.findByFirstName(firstName);
    }

    @Override
    public Customer getCustomerByLName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    @Override
    public Customer getCustomerByPan(String pan) {
        return customerRepository.findByPan(pan);
    }

    @Override
    public List<Customer> getCustomersByAddress(String address) {
        return customerRepository.findByAddress(address);
    }

    @Override
    public Account showAccountDetailsByCustomerId(Long customerId) {
        return accountRepository.findByCustomerId(customerId);
    }

//    @Override
//    public List<Transaction> showTransactionRecords(Long customerId) {
//
//    }
}
