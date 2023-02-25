package com.example.junsi;

import com.example.junsi.fxmlcontroller.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLogin extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader =new FXMLLoader(MainApp.class.getResource("/com/example/junsi/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("钧思培训系统管理员登录");
        //stage.setMaximized(true);
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
}
