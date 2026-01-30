package com.poly.ASM.Service;

import com.poly.ASM.entity.Account;

import java.util.List;

public interface AccountService {
    Account findByUsername(String username);
    Account create(Account account);
    Account update(Account account);
    List<Account> findAll();
}

