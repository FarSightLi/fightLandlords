package org.example.entity;

public class UserAccount {
    private String id;
    private String password;
    private String email;
    private int balance;

    public UserAccount(String id, String password, String email, int balance) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.balance = balance;
    }

    public UserAccount() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }
}

