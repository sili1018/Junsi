package com.example.junsi.fxmlcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URL;
import java.util.ResourceBundle;

public class Ziliao implements Initializable  {
    public BorderPane bpane;//定义面板容器，与fxml文件中面板的fx:id一致
    public MediaPlayer mPlayer;//定义媒体播放器对象

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //创建字符串格式的媒体源路径，视频在项目resource目录下
        String url="file://"+getClass().getResource("/com/example/junsi/image/ziliao.mp4").getPath();
        //创建字符串格式的媒体源路径，视频在本地目录下
        // String url = "file:///g:/home-1.mp4";
        //创建媒体对象
        Media media=new Media(url);
        //实例化媒体播放器对象
        mPlayer=new MediaPlayer(media);
        //创建媒体播放视图
        MediaView mediaView=new MediaView(mPlayer);
        //设置媒体播放视图的宽度和高度与面板容器相同
        mediaView.setFitWidth(bpane.getWidth());
        mediaView.setFitHeight(bpane.getHeight());
        bpane.setCenter(mediaView);//设置面板容器的中部内容为媒体播放视图
        //将本控制器对象加入自定义控制器管理集合，名字为“welcome"
        ControllerManger.controllerMap.put("welcome", this);
    }

    public void play(ActionEvent actionEvent) {
        mPlayer.play();//播放视频
    }
}
