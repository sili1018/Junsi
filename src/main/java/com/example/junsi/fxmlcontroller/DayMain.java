package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Day;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.DayService;
import com.example.junsi.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class DayMain implements Initializable {
    public TableView tbStudent;
    public TableColumn tcFirst;
    public TableColumn tcSecond;
    public TableColumn tcThird;
    public TableColumn tcFourth;

    public TextField txtKey;
    DayService service=new DayService();
    Day day=new Day();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initTable(service.getStudents());
        }
    public void initTable(ArrayList<Day> days) {
        ControllerManger.controllerMap.put("DayMain",this);
        //设置数据表格源
        ObservableList<Day> data = FXCollections.observableArrayList(days);
        //设置每一列的值，【tcStuno】等为界面数据表格中列的fx:id，【stuno】等为Student类中的成员变量名称
        tcFirst.setCellValueFactory(new PropertyValueFactory<>("first"));
        tcSecond.setCellValueFactory(new PropertyValueFactory<>("second"));
        tcThird.setCellValueFactory(new PropertyValueFactory<>("third"));
        tcFourth.setCellValueFactory(new PropertyValueFactory<>("fourth"));

        //设置TableView（tbStudent）的数据源
        tbStudent.setItems(data);
        //tbStudent.setEditable(true);//设置数据表格可编辑
    }


    public void btnEdit(ActionEvent actionEvent) throws IOException {
        //将选中的学生对象传递给窗口
        day=(Day) tbStudent.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/editDay.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        //标题
        stage.setTitle("编辑课表");
        //设置窗体不关闭不能使用其他窗体
        stage.initModality(Modality.APPLICATION_MODAL);
        //设置窗口大小不能改变
        stage.setResizable(false);
        stage.show();
    }
}
