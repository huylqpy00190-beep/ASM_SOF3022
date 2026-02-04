package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.AccountService;
import com.poly.ASM.dao.AccountRepository;
import com.poly.ASM.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepo;

    @Override
    public Account findByUsername(String username) {
        return accountRepo.findById(username).orElse(null);
    }

    @Override
    public Account create(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepo.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepo.findAll();
    }
    @Override
    public void delete(String username) {
        accountRepo.deleteById(username);
    }
    @Override
    public Account findByEmail(String email) {
        return accountRepo.findByEmail(email); // Gọi từ Repository đã có của bạn
    }
    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }
}


