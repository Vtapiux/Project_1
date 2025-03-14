package com.revature.project1.service;

import com.revature.project1.Entities.Account;
import com.revature.project1.repository.AccountRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAllAccounts() {return accountRepository.findAll();}
}
