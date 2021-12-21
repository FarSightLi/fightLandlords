package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.AccountDAO;
import org.example.entity.UserAccount;
import org.example.utils.MybatisUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {

    SqlSession sqlSession= MybatisUtils.getSqlSession();
    //每个方法都能用到，提前声明，在方法中直接使用
    AccountDAO accountDao=sqlSession.getMapper(AccountDAO.class);
    Scanner scanner=new Scanner(System.in);

    @Override
    public void findAll() {
        List<UserAccount> userAccounts= accountDao.findAll();
        userAccounts.forEach(System.out::println);
        sqlSession.close();//讲查询，赋值，打印在方法中完成，使使用时更简洁
    }

    @Override
    public int allNum() {
        int nums=accountDao.allNum();
        return nums ;
    }

    @Override
    public void login() {
        boolean goOn=true;
        while (goOn){
            System.out.println("请输入你的邮箱");
            String email=scanner.nextLine();
            System.out.println("请输入你的密码");
            String password=scanner.nextLine();
            int haveAccount = accountDao.login(email,password);
            if(haveAccount==1){
                System.out.println("登录成功");
                goOn=false;
            }else {
                System.out.println("账号或密码输入有误，请重新输入");
            }
        }
        sqlSession.close();
    }

    @Override
    public void signUp() {
        System.out.println("请输入你的邮箱");
        String email=scanner.nextLine();
        System.out.println("请输入你的密码");
        String password=scanner.nextLine();
        //统计总条数，加一便得的新id
        int i =allNum()+1;
        //将总条数格式化
        String id=new DecimalFormat("00000").format(i);
        accountDao.signUp(id,email,password);
        System.out.println("注册成功");
        System.out.println("这是你的id："+id);
        sqlSession.close();
    }
}
