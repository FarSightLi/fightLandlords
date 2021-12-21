package org.example;


import org.example.entity.UserAccount;
import org.example.service.AccountServiceImpl;

public class Test {
    public static void main(String[] args) {
        AccountServiceImpl accountService=new AccountServiceImpl();
        //创建对象，赋给service层signup，再赋给dao层
//        accountService.signUp();
        accountService.login();


    }

}
