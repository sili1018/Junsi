package com.example.junsi.fxmlcontroller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LeftMenu01 {
    public void item01Click(MouseEvent mouseEvent) throws IOException {
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/fristFace.fxml"));
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }

    public void item02Click(MouseEvent mouseEvent) throws Exception {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/studentMain.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }
    public void item04Click(MouseEvent mouseEvent) throws Exception {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/courseMain.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }
    public void item03Click(MouseEvent mouseEvent) throws Exception {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/teacherMain.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }
    public void item05Click(MouseEvent mouseEvent) throws Exception {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/dayMain.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }
    public void item06Click(MouseEvent mouseEvent) throws Exception {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/tongji.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }

    public void item07Click(MouseEvent mouseEvent) throws IOException {
        //获取界面文件
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/ziliao.fxml"));
        //获取界面中的根面板容器
        Pane cmdPane=(Pane)fxmlLoader.load();
        //在子窗体中获取父窗体的控制器
        Main mainController=(Main) ControllerManger.controllerMap.get("mainController");
        //设置主界面上下左右布局中间布局的内容为上述指定界面
        mainController.mainPane.setCenter(cmdPane);
    }
}
