package com.example.junsi.fxmlcontroller;

import com.example.junsi.service.StudentJDBC;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Main implements Initializable {
    public ImageView libexit;
    public BorderPane mainPane;
    public void exitsys(MouseEvent mouseEvent) {
        //使用系统确认框询问
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("钧思培训系统");
        //设置对话框的内容文本
        alert.setContentText("您确定要退出吗？");
        //显示对话框，并等待按钮返回
        Optional<ButtonType> result=alert.showAndWait();
        //判断返回的按钮类型是确定还是取消，再据此分别进行下一步处理
        if(result.get()==ButtonType.OK){
            Stage stage= (Stage) libexit.getScene().getWindow();
            stage.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ControllerManger.controllerMap.put("mainController",this);
    }
}
