package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.entity.UserAccount;

import java.util.List;

public interface AccountDAO {
    List<UserAccount> findAll();
    int signUp(@Param("id") String id,@Param("email") String email,@Param("password") String password);
    int allNum();
    int findByEmail(String email);
    String getId(String email);
    int login(@Param("email")String email , @Param("password") String password);
}
