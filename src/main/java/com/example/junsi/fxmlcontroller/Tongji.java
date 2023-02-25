package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;
import com.example.junsi.service.*;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class Tongji implements Initializable {

    public Label studentnum;
    public Label teachernum;
    public Label coursenum;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initTable();

    }
    public void initTable() {
//        StudentJDBC studentJDBC=new StudentJDBC();
//        TeacherJDBC teacherJDBC=new TeacherJDBC();
//        CourseJDBC  courseJDBC =new CourseJDBC();
//        try {
//            ArrayList<Student> students=studentJDBC.init();
//            ArrayList<Teacher> teachers=teacherJDBC.init();
//            ArrayList<Course>  courses=courseJDBC.init();
//            studentnum.setText(students.size()+"位");
//            teachernum.setText(teachers.size()+"位");
//            coursenum.setText(courses.size()+"门");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        StudentService studentService=new StudentService();
        TeacherService teacherService=new TeacherService();
        CourseService  courseService=new CourseService();
        try{
            ArrayList<Student> students=studentService.getStudents();
            ArrayList<Teacher> teachers=teacherService.getTeachers();
            ArrayList<Course>  courses=courseService.getCourses();
            studentnum.setText(students.size()+"位");
            teachernum.setText(teachers.size()+"位");
            coursenum.setText(courses.size()+"门");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
