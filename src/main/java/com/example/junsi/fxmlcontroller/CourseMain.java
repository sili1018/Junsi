package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Course;
import com.example.junsi.pojo.Student;
import com.example.junsi.service.CourseService;
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

import static com.example.junsi.service.CourseService.courses;

public class CourseMain implements Initializable {
    public TableView tbCourse;
    public TableColumn tcStun;
    public TableColumn tcName;
    public TableColumn tcTname;
    public TextField txtKey;
    CourseService service =new CourseService();
    Course course=new Course();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //调用数据操作类获取数据加载数据表格（TableView）
        initTable(service.getCourses());

    }
    public void initTable(ArrayList<Course> courses) {
        ControllerManger.controllerMap.put("CourseMain",this);
        //设置数据表格源
        ObservableList<Course> data = FXCollections.observableArrayList(courses);
        //设置每一列的值，【tcStuno】等为界面数据表格中列的fx:id，【stuno】等为Student类中的成员变量名称
        tcStun.setCellValueFactory(new PropertyValueFactory<>("cno"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        tcTname.setCellValueFactory(new PropertyValueFactory<>("Tname"));

        //设置TableView（tbStudent）的数据源
        tbCourse.setItems(data);
        //tbStudent.setEditable(true);//设置数据表格可编辑
    }

    //查询成绩
    public void findClick(ActionEvent actionEvent) {
        initTable(service.findStu(txtKey.getText()));
    }

    //删除成绩
    public void delClick(ActionEvent actionEvent) {
        //获取用户选定的行数据
        Course s1=(Course) tbCourse.getSelectionModel().getSelectedItem();
        //使用系统确认框询问
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("您确定要删除课程名为【" + s1.getCname() + "】的课程吗？");
        // 设置对话框的内容文本
        //alert.setContentText("尊敬的用户，你真的要卸载我吗？");
        // 显示对话框，并等待按钮返回
        Optional<ButtonType> result = alert.showAndWait();
        // 判断返回的按钮类型是确定还是取消，再据此分别进一步处理
        if (result.get() == ButtonType.OK) { // 单击了确定按钮OK
            // 调用数据操作类删除学生成绩的方法
            service.delCourse(s1.getCno());
            //重新加载数据表格视图数据
            initTable(service.getCourses());
        }
    }

    public void add(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/addCourse.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        //标题
        stage.setTitle("添加课程");
        //设置窗体不关闭不能使用其他窗体
        stage.initModality(Modality.APPLICATION_MODAL);
        //设置窗口大小不能改变
        stage.setResizable(false);
        stage.show();
    }

    public void btnEdit(ActionEvent actionEvent) throws IOException {
        //将选中的学生对象传递给窗口
        course=(Course) tbCourse.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/editCourse.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        //标题
        stage.setTitle("编辑课程");
        //设置窗体不关闭不能使用其他窗体
        stage.initModality(Modality.APPLICATION_MODAL);
        //设置窗口大小不能改变
        stage.setResizable(false);
        stage.show();
    }
}
