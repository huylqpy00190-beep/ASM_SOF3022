package com.poly.ASM.Service;

import com.poly.ASM.entity.Account;

public interface AuthService {
    void login(Account user);
    void logout();
    Account getUser();
    boolean isLogin();
    boolean isAdmin();
}
