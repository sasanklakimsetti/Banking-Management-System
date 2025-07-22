package com.bms.service.savings;

import com.bms.factory.SavingsAccountFactory;
import com.bms.model.Account;
import com.bms.model.Customer;
import com.bms.model.savings.SavingsAccount;
import com.bms.repository.AccountRepository;
import com.bms.repository.CustomerRepository;
import com.bms.repository.savings.SavingsAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SavingsAccountServiceImpl implements SavingsAccountService{

}
