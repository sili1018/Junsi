package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.CourseService;
import com.example.junsi.service.StudentService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCourse implements Initializable {

    public TextField txtCno;
    public TextField txtCname;
    public TextField txtTname;
    public Label msgStuno;


    public boolean isadd=true;
    CourseService service=new CourseService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnOk(ActionEvent actionEvent) {
        if(isadd){
            //添加学生
            String Cno=txtCno.getText();
            String Cname=txtCname.getText();
            String Tname=txtTname.getText();
            Course course=new Course(Cno,Cname,Tname);
            service.addCourse(course);
            //关闭窗口
            Stage stage=(Stage) txtCno.getScene().getWindow();
            stage.close();
            //刷新表
            CourseMain cm=(CourseMain) ControllerManger.controllerMap.get("CourseMain");
            cm.initTable(service.getCourses());
        }
    }

}
