package com.example.junsi.pojo;

import java.io.Serializable;

public class Manager<T> implements Serializable {
    private T Account;
    private T Password;


    public Manager() {
    }

    public Manager(T Account, T Password) {
        this.Account = Account;
        this.Password = Password;
    }

    /**
     * 获取
     * @return Account
     */
    public T getAccount() {
        return Account;
    }

    /**
     * 设置
     * @param Account
     */
    public void setAccount(T Account) {
        this.Account = Account;
    }

    /**
     * 获取
     * @return Password
     */
    public T getPassword() {
        return Password;
    }

    /**
     * 设置
     * @param Password
     */
    public void setPassword(T Password) {
        this.Password = Password;
    }

    public String toString() {
        return "Manager{Account = " + Account + ", Password = " + Password + "}";
    }
}
