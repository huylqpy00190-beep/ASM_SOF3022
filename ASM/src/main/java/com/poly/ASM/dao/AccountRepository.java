package com.poly.ASM.dao;

import com.poly.ASM.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository
        extends JpaRepository<Account, String> {

    // Tìm theo email
    Account findByEmail(String email);

    // Tìm user theo vai trò
    List<Account> findByAdmin(boolean admin);

    // Tìm user theo trạng thái
    List<Account> findByActivated(boolean activated);
}


