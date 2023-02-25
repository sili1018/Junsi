package com.example.junsi.service;

import com.example.junsi.pojo.Manager;

import java.io.IOException;
import java.util.ArrayList;

public class LoginService {
    private static ArrayList<Manager> managers=new ArrayList<>();
    static {
        ManagerIO managerIO=new ManagerIO();
        try {
            managers=managerIO.Init();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean findAccount(Manager m){
        for (Manager manager:managers) {
            if(manager.getAccount().equals(m.getAccount())){
                return true;
            }
        }
        return false;
    }
}
