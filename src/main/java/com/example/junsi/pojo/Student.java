package com.example.junsi.pojo;


import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.example.junsi.fxmlcontroller.StudentMain;
import com.example.junsi.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.alibaba.excel.annotation.ExcelProperty;
import org.junit.Test;

import java.io.Serializable;

@ContentRowHeight(20)//表体行高
@HeadRowHeight(20)//表头行高
@ColumnWidth(20)//列宽

@Data
public class Student implements Serializable {
    @ExcelProperty("学号")//列标题
    private String Stuno;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("课程")
    private String coure;

    public Student() {
    }

    public Student(String stuno, String name, Integer age, String sex, String coure) {
        Stuno = stuno;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.coure = coure;
    }

}

