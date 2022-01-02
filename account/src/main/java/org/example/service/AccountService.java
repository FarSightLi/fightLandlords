package org.example.service;

import org.example.entity.UserAccount;

public interface AccountService {
    void findAll();
    boolean signUp(String email,String password,String password1);
    int allNum();
    boolean login(String email,String password);
}
