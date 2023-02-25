package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Day;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.DayService;
import com.example.junsi.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditDay implements Initializable {

    public TextField txtFirst;
    public TextField txtSecond;
    public TextField txtThird;
    public TextField txtFourth;
    public Button editStu;
    public boolean isedit=true;
    DayService service=new DayService();
    public void btnEdit(ActionEvent actionEvent) {
        if(isedit){
            String stuno=txtFirst.getText();
            String name=txtSecond.getText();
            String  age=txtThird.getText();
            String sex=txtFourth.getText();
            Day stu=new Day(stuno,name,age,sex);
            service.updataStudent(stuno,stu);
            Stage stage=(Stage) txtFirst.getScene().getWindow();
            stage.close();
            DayMain dm=(DayMain) ControllerManger.controllerMap.get("DayMain");
            dm.initTable(service.getStudents());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DayMain dayMain=(DayMain) ControllerManger.controllerMap.get("DayMain");
        Day selectStudent=dayMain.day;
        txtFirst.setText(selectStudent.getFirst());
        txtSecond.setText(selectStudent.getSecond());
        txtThird.setText(selectStudent.getThird());
        txtFourth.setText(selectStudent.getFourth());
    }
}
