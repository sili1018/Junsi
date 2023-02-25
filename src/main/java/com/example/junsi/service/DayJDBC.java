package com.example.junsi.service;

import com.example.junsi.pojo.Day;
import com.example.junsi.pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class DayJDBC {
    public  ArrayList<Day> list=new ArrayList<>();
    public  ArrayList init() throws SQLException {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/课设?useSSL=false";
        String username="root";
        String password="a1515546861";
        Connection conn= DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="select * from day";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1,"小明");
        //5. 执行SQL语句
        ResultSet rs=pstmt.executeQuery();

        while (rs.next()) {
            String id= (String) rs.getObject("first");
            String name= (String) rs.getObject("second");
            String age= (String) rs.getObject("third");
            String sex= (String) rs.getObject("fourth");
            list.add(new Day(id,name,age,sex));
        }
        //6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        pstmt.close();
        conn.close();
        return list;
    }
}
