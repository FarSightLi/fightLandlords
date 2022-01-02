package org.example.controller;

import org.example.service.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    AccountServiceImpl accountService=new AccountServiceImpl();

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("dologin")
    public String doLogin(HttpServletRequest httpServletRequest){
        String email = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        //调用service层方法验证账号密码正确性
        boolean loginSuccess=accountService.login(email,password);
        if (loginSuccess){
            return "welcome";
        }else {
            return "login";
        }
    }

    @GetMapping("signup")
    public String signUp(){
        return "signup";
    }

    @GetMapping("dosignup")
    public String doSignUp(HttpServletRequest httpServletRequest){
        String email = httpServletRequest.getParameter("username");
        String password = httpServletRequest.getParameter("password");
        String password2 = httpServletRequest.getParameter("password2");
        //调用service层方法验证账号是否存在
        boolean signUpSuccess=accountService.signUp(email,password,password2);
        if (signUpSuccess){
            return "login";
        }else {
            return "signup";
        }
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }


}
