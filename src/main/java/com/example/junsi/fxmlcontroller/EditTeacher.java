package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;
import com.example.junsi.service.StudentService;
import com.example.junsi.service.TeacherService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditTeacher implements Initializable {

     public TextField txtTno;
    public TextField txtAge;
    public TextField txtTname;
    public TextField txtCname;
    public Label msgTno;
    public Label msgTname;
    public Label msgAge;
    public Label msgCname;
    public Button editStu;
    public boolean isedit=true;
    TeacherService service=new TeacherService();
    public void btnEdit(ActionEvent actionEvent) {
        if(isedit){
            String Tno=txtTno.getText();
            String Tname=txtTname.getText();
            String  age=txtAge.getText();
            String Cname=txtCname.getText();
            Teacher teacher=new Teacher(Tno,Tname,Integer.parseInt(age),Cname);
            service.updataTeacher(Tno,teacher);
            Stage stage=(Stage) txtTno.getScene().getWindow();
            stage.close();
            TeacherMain st=(TeacherMain) ControllerManger.controllerMap.get("TeacherMain");
            st.initTable(service.getTeachers());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TeacherMain TeacherMain=(TeacherMain) ControllerManger.controllerMap.get("TeacherMain");
        Teacher selectStudent=TeacherMain.teacher;
        txtTno.setText(selectStudent.getTno());
        txtTname.setText(selectStudent.getTname());
        txtAge.setText(selectStudent.getAge().toString());
        txtCname.setText(selectStudent.getCname());
    }
}
