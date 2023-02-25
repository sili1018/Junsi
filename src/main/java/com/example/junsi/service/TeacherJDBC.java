package com.example.junsi.service;

import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class TeacherJDBC {
    public ArrayList<Teacher> list=new ArrayList<>();
    public  ArrayList init() throws SQLException, ClassNotFoundException {
        Class clazz= JDBC.class;
        JDBC jdbc=new JDBC();
        //获取指定的属性:
        //getDeclaredField(String name):获取运行时类中指定变量名的属性
        Field url1= null;
        Field username1=null;
        Field password1=null;
        try {
            url1 = clazz.getDeclaredField("url");
            username1 = clazz.getDeclaredField("username");
            password1 = clazz.getDeclaredField("password");
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
        //setAccessible：保证当前属性是可访问的
        url1.setAccessible(true);
        password1.setAccessible(true);
        username1.setAccessible(true);
        //设置当前属性的值
        //获取当前属性的值
        //get(): 参数一：获取哪个对象的当前属性值
        String url=null;
        String username=null;
        String password=null;
        try {
             url = (String )url1.get(jdbc);
             username = (String )username1.get(jdbc);
             password = (String )password1.get(jdbc);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        //Class clazz= JDBC.class;
        //创建运行时类的对象
        //String url="jdbc:mysql://127.0.0.1:3306/课设?useSSL=false";
        //String username="root";
        //String password="a1515546861";
        Connection conn= DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="select * from teacher";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1,"小明");
        //5. 执行SQL语句
        ResultSet rs=pstmt.executeQuery();

        while (rs.next()) {
            String Tno= (String) rs.getObject("Tno");
            String Tname= (String) rs.getObject("Tname");
            Integer age= (Integer) rs.getObject("age");
            String Cname= (String) rs.getObject("Cname");
            list.add(new Teacher(Tno,Tname,age,Cname));
        }
        //6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        pstmt.close();
        conn.close();
        return list;
    }
}
