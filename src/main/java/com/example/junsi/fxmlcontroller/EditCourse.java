package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.CourseService;
import com.example.junsi.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditCourse implements Initializable {

     public TextField txtcno;
    public TextField txtCname;
    public TextField txtTname;
    public Button editStu;
    public boolean isedit=true;
    CourseService service = new CourseService();
    public void btnEdit(ActionEvent actionEvent) {
        if(isedit){
            String stuno=txtcno.getText();
            String name=txtCname.getText();
            String  Tname=txtTname.getText();
            Course course= new Course(stuno,name,Tname);
            service.updataCourse(stuno,course);
            Stage stage=(Stage) txtcno.getScene().getWindow();
            stage.close();
            CourseMain sm= (CourseMain) ControllerManger.controllerMap.get("CourseMain");
            sm.initTable(service.getCourses());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CourseMain studentMain=(CourseMain) ControllerManger.controllerMap.get("CourseMain");
        Course selectStudent=studentMain.course;
        txtcno.setText(selectStudent.getCno());
        txtCname.setText(selectStudent.getCname());
        txtTname.setText(selectStudent.getTname());
    }
}
