package com.example.junsi.fxmlcontroller;

import com.example.junsi.MainApp;
import com.example.junsi.MainLogin;
import com.example.junsi.pojo.Manager;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.LoginService;
import com.example.junsi.service.ManagerIO;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Login {
    public TextField txtAccount;
    public TextField txtPassword;
    public void btnOk(ActionEvent actionEvent) throws Exception {
            //添加学生
            String Account=txtAccount.getText();
            String Password=txtPassword.getText();
            Manager<String> manager=new Manager(Account,Password);
            LoginService service=new LoginService();
            boolean flag=service.findAccount(manager);
            //关闭窗口
            Stage stage=(Stage) txtAccount.getScene().getWindow();
            stage.close();
            if(flag){
                MainApp app=new MainApp();
                Stage stage1=new Stage();
                app.start(stage1);
            }else{
                MainLogin ml=new MainLogin();
                Stage stage1=new Stage();
                ml.start(stage1);

            }
    }
    }
