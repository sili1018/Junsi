package com.example.junsi.service;

import com.example.junsi.pojo.Manager;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class ManagerIO {
    ArrayList<Manager> list=new ArrayList<>();
    File file=new File("C:\\Users\\jhon\\IdeaProjects\\JunSi\\src\\main\\resources\\files\\ManagersAccount.txt");
    public ArrayList<Manager> Init() throws IOException {
        try(BufferedReader fr = new BufferedReader(new FileReader(file))){
            String s1=null;
            String s2=null;
            while((s1=fr.readLine())!=null){
                s2=fr.readLine();
                list.add(new Manager<String>(s1,s2));
            }
        }
        return list;
    }
}
