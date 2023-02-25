package com.example.junsi;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/com/example/junsi/fxml/main.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            //stage.setTitle("钧思培训系统");
            stage.setScene(scene);
            //设置舞台(窗体)最大化
            stage.setMaximized(true);
            //设置舞台(窗体)无标题栏，关闭等按钮
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
    }
    public void Init(){launch();}
}