package com.guru.Banking_App.service.impl;

import com.guru.Banking_App.dto.AccountDto;
import com.guru.Banking_App.entity.Account;
import com.guru.Banking_App.mapper.AccountMapper;
import com.guru.Banking_App.repository.AccountRepository;
import com.guru.Banking_App.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account= AccountMapper.mapToAccount(accountDto);

        Account saved = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(saved);
    }

    @Override
    public AccountDto getAccountById(Long id) {

        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found in DB"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found in DB"));

        double newAmount = account.getBalance() + amount;
        account.setBalance(newAmount); // Add balance

        Account savedAccount = accountRepository.save(account); // save account
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found in DB"));

        if(account. getBalance() < amount){
            throw new RuntimeException("Insufficient Amount");
        }

        double newAmount= account.getBalance() - amount;
        account.setBalance(newAmount);

        Account savedAccount = accountRepository.save(account); // save account
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List <Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found in DB"));

        accountRepository.deleteById(id);
    }

    @Override
    public AccountDto update(Long id, AccountDto accountDto) {

        Account account= AccountMapper.mapToAccount(accountDto);

        Account oldaccount = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account Not Found in DB"));

        oldaccount.setBalance(account.getBalance());

        if (account.getAccountHolderName() != null && !account.getAccountHolderName().isEmpty()){
            oldaccount.setAccountHolderName(account.getAccountHolderName());
        }

        Account saved = accountRepository.save(oldaccount);

        return AccountMapper.mapToAccountDto(saved);
    }


}
