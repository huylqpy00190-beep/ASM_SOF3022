package com.poly.ASM.Service;

import com.poly.ASM.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    Account findByUsername(String username);
    Account create(Account account);
    Account update(Account account);
    List<Account> findAll();
    void delete(String username);
    Account findByEmail(String email);
    Page<Account> findAll(Pageable pageable);
}

