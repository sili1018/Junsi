package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Student;
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

public class AddStudent implements Initializable {

    public TextField txtStuno;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtCoure;
    public TextField txtSex;
    public Label msgStuno;
    public Label msgName;
    public Label msgAge;
    public Label msgCoure;
    public Label msgSex;

    public boolean isadd=true;
    StudentService service=new StudentService();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtStuno.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(oldValue && !newValue){
                    String stuno=txtStuno.getText();
                    if(stuno.length()==0){
                        msgStuno.setText("学号不能为空！");
                        txtStuno.requestFocus();
                        isadd=false;
                    } else if (service.findByStu(stuno)!=null){
                        msgStuno.setText("学号已存在！");
                        txtStuno.requestFocus();
                        isadd=false;
                    } else{
                        msgStuno.setText("");
                        isadd=true;
                    }
                }
            }
        });
    }

    public void btnOk(ActionEvent actionEvent) {
        if(isadd){
            //添加学生
            String stuno=txtStuno.getText();
            String name=txtName.getText();
            String age=txtAge.getText();
            String coure=txtCoure.getText();
            String sex=txtSex.getText();
            Student student=new Student(stuno,name,Integer.parseInt(age),coure,sex);
            service.addStudent(student);
            //关闭窗口
            Stage stage=(Stage) txtStuno.getScene().getWindow();
            stage.close();
            //刷新表
            StudentMain sc=(StudentMain) ControllerManger.controllerMap.get("StudentMain");
            sc.initTable(service.getStudents());
        }
    }
}
