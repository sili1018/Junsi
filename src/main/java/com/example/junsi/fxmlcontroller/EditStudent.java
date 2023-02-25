package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Student;
import com.example.junsi.service.StudentService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EditStudent implements Initializable {

     public TextField txtStuno;
    public TextField txtAge;
    public TextField txtName;
    public TextField txtCoure;
    public TextField txtSex;
    public Label msgStuno;
    public Label msgName;
    public Label msgAge;
    public Label msgCoure;
    public Label msgSex;
    public Button editStu;
    public boolean isedit=true;
    StudentService service=new StudentService();
    public void btnEdit(ActionEvent actionEvent) {
        if(isedit){
            String stuno=txtStuno.getText();
            String name=txtName.getText();
            String  age=txtAge.getText();
            String sex=txtSex.getText();
            String coure=txtCoure.getText();
            Student stu=new Student(stuno,name,Integer.parseInt(age),sex,coure);
            service.updataStudent(stuno,stu);
            Stage stage=(Stage) txtStuno.getScene().getWindow();
            stage.close();
            StudentMain sm= (StudentMain) ControllerManger.controllerMap.get("StudentMain");
            sm.initTable(service.getStudents());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        StudentMain studentMain=(StudentMain) ControllerManger.controllerMap.get("StudentMain");
        Student selectStudent=studentMain.student;
        txtStuno.setText(selectStudent.getStuno());
        txtName.setText(selectStudent.getName());
        txtAge.setText(selectStudent.getAge().toString());
        txtSex.setText(selectStudent.getSex());
        txtCoure.setText(selectStudent.getCoure());
    }
}
