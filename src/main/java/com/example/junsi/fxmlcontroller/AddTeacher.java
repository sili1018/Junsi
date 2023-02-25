package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;
import com.example.junsi.service.StudentService;
import com.example.junsi.service.TeacherService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddTeacher implements Initializable {

    public TextField txtTno;
    public TextField txtTname;
    public TextField txtAge;
    public TextField txtCname;
    public Label msgTno;
    public Label msgTname;
    public Label msgAge;
    public Label msgCname;

    public boolean isadd=true;
    TeacherService service=new TeacherService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtTno.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue && !newValue){
                    String stuno=txtTno.getText();
                    if(stuno.length()==0){
                        msgTno.setText("教师号不能为空！");
                        txtTno.requestFocus();
                        isadd=false;
                    } else if (service.findByStu(stuno)!=null){
                        msgTno.setText("教师号已存在！");
                        txtTno.requestFocus();
                        isadd=false;
                    } else{
                        msgTno.setText("");
                        isadd=true;
                    }
                }
            }
        });
    }
    public void btnOk(ActionEvent actionEvent) {
        if(isadd){
            //添加学生
            String stuno=txtTno.getText();
            String name=txtTname.getText();
            String age=txtAge.getText();
            String coure=txtCname.getText();
            Teacher teacher =new Teacher(stuno,name,Integer.parseInt(age),coure);
            service.addStudent(teacher);
            //关闭窗口
            Stage stage=(Stage) txtTno.getScene().getWindow();
            stage.close();
            //刷新表
            TeacherMain tm=(TeacherMain) ControllerManger.controllerMap.get("TeacherMain");
            tm.initTable(service.getTeachers());
        }
    }
}
