package com.example.junsi.service;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;

import java.sql.*;
import java.util.ArrayList;

public class CourseJDBC {
    public ArrayList<Course> list=new ArrayList<>();
    public  ArrayList init() throws SQLException {
        //1.注册驱动
        //Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        String url="jdbc:mysql://127.0.0.1:3306/课设?useSSL=false";
        String username="root";
        String password="a1515546861";
        Connection conn= DriverManager.getConnection(url,username,password);
        //3.定义sql
        String sql="select * from course";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //pstmt.setString(1,"小明");
        //5. 执行SQL语句
        ResultSet rs=pstmt.executeQuery();

        while (rs.next()) {
            String id=(String) rs.getObject("cno");
            String name=(String) rs.getObject("name");
            String Tname=(String) rs.getObject("tname");
            list.add(new Course(id,name,Tname));
        }
        //6.关闭连接释放资源（一定要做），先开后关
        rs.close();
        pstmt.close();
        conn.close();
        return list;
    }
}
