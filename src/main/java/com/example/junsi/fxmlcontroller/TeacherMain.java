package com.example.junsi.fxmlcontroller;

import com.example.junsi.pojo.Student;
import com.example.junsi.pojo.Teacher;
import com.example.junsi.service.TeacherService;
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

public class TeacherMain implements Initializable {
    public ComboBox cmbFind;
    public TableView tbStudent;
    public TableColumn tcStun;
    public TableColumn tcName;
    public TableColumn tcSex;
    public TableColumn tcCoure;
    public TableColumn tcAge;
    public TextField txtKey;
    TeacherService service=new TeacherService();
    Teacher teacher=new Teacher();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //下拉框填充数据，sitem为ComboBox下拉列表组件的fx:id
        cmbFind.getItems().add("教师号");
        cmbFind.getItems().add("教师名");
        //选中下拉框中的第一项
        cmbFind.getSelectionModel().select(0);
        //调用数据操作类获取数据加载数据表格（TableView）
        initTable(service.getTeachers());

    }
    public void initTable(ArrayList<Teacher> teachers) {
        ControllerManger.controllerMap.put("TeacherMain",this);
        //设置数据表格源
        ObservableList<Teacher> data = FXCollections.observableArrayList(teachers);
        //设置每一列的值，【tcStuno】等为界面数据表格中列的fx:id，【stuno】等为Student类中的成员变量名称
        tcStun.setCellValueFactory(new PropertyValueFactory<>("Tno"));
        tcName.setCellValueFactory(new PropertyValueFactory<>("Tname"));
        tcAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tcSex.setCellValueFactory(new PropertyValueFactory<>("Cname"));
        //设置TableView（tbStudent）的数据源
        tbStudent.setItems(data);
        //tbStudent.setEditable(true);//设置数据表格可编辑
    }

    //查询成绩
    public void findClick(ActionEvent actionEvent) {
        initTable(service.findStu(txtKey.getText()));
    }

    //删除成绩
    public void delClick(ActionEvent actionEvent) {
        //获取用户选定的行数据
        Teacher T1=(Teacher) tbStudent.getSelectionModel().getSelectedItem();
        //使用系统确认框询问
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("您确定要删除教师号为【" + T1.getTno() + "】的成绩吗？");
        // 设置对话框的内容文本
        //alert.setContentText("尊敬的用户，你真的要卸载我吗？");
        // 显示对话框，并等待按钮返回
        Optional<ButtonType> result = alert.showAndWait();
        // 判断返回的按钮类型是确定还是取消，再据此分别进一步处理
        if (result.get() == ButtonType.OK) { // 单击了确定按钮OK
            // 调用数据操作类删除学生成绩的方法
            service.delStudent(T1.getTno());
            //重新加载数据表格视图数据
            initTable(service.getTeachers());
        }
    }

    public void add(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/addTeacher.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        //标题
        stage.setTitle("编辑教师");
        //设置窗体不关闭不能使用其他窗体
        stage.initModality(Modality.APPLICATION_MODAL);
        //设置窗口大小不能改变
        stage.setResizable(false);
        stage.show();
    }

    public void btnEdit(ActionEvent actionEvent) throws IOException {
        //将选中的学生对象传递给窗口
        teacher=(Teacher)tbStudent.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader= new FXMLLoader(getClass().getResource("/com/example/junsi/fxml/editTeacher.fxml"));
        Scene scene=new Scene(fxmlLoader.load());
        Stage stage=new Stage();
        stage.setScene(scene);
        //标题
        stage.setTitle("编辑老师");
        //设置窗体不关闭不能使用其他窗体
        stage.initModality(Modality.APPLICATION_MODAL);
        //设置窗口大小不能改变
        stage.setResizable(false);
        stage.show();
    }
}
