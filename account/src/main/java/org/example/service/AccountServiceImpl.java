package org.example.service;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.AccountDAO;
import org.example.entity.UserAccount;
import org.example.utils.MybatisUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class AccountServiceImpl implements AccountService {


    Scanner scanner=new Scanner(System.in);

    @Override
    public void findAll() {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        AccountDAO accountDao=sqlSession.getMapper(AccountDAO.class);
        List<UserAccount> userAccounts= accountDao.findAll();
        userAccounts.forEach(System.out::println);
        sqlSession.close();//讲查询，赋值，打印在方法中完成，使使用时更简洁
    }

    @Override
    public int allNum() {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        AccountDAO accountDao=sqlSession.getMapper(AccountDAO.class);
        int nums=accountDao.allNum();
        return nums ;
    }

    @Override
    public boolean login(String email,String password) {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        AccountDAO accountDao=sqlSession.getMapper(AccountDAO.class);
        int haveAccount = accountDao.login(email,password);
        sqlSession.close();
        if(haveAccount==1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean signUp(String email,String password,String password1) {
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        AccountDAO accountDao=sqlSession.getMapper(AccountDAO.class);
        int haveEmail= accountDao.findByEmail(email);
        if(haveEmail==0){
            //统计总条数，加一便得的新id
            int i =allNum()+1;
            //将总条数格式化a
            String id=new DecimalFormat("00000").format(i);
            accountDao.signUp(id,email,password);
            sqlSession.close();
            return true;
        }else {
           return false;
        }
    }
}
