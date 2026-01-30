package com.poly.ASM.ServiceImpl;

import com.poly.ASM.Service.AuthService;
import com.poly.ASM.entity.Account;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class AuthServiceImpl implements AuthService {

    private Account user;

    @Override
    public void login(Account user) {
        this.user = user;
    }

    @Override
    public void logout() {
        this.user = null;
    }

    @Override
    public Account getUser() {
        return user;
    }

    @Override
    public boolean isLogin() {
        return user != null;
    }

    @Override
    public boolean isAdmin() {
        return user != null && Boolean.TRUE.equals(user.getAdmin());
    }
}

