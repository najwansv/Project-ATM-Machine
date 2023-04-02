package org.example;

public class UserData {
    private String userPin;
    private int balance;
    private int userName;

    public String getUserPin() {
        return userPin;
    }

    public int getBalance() {
        return balance;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserPin(String userPin) {
        this.userPin = userPin;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }
}
