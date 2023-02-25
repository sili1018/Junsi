package com.example.junsi.pojo;

import com.example.junsi.fxmlcontroller.TeacherMain;
import com.example.junsi.service.TeacherService;
import org.junit.Test;

public class Teacher {
    private String Tno;
    private String Tname;
    private Integer age;
    private String Cname;

    public Teacher() {
    }

    public Teacher(String Tno, String Tname, Integer age, String Cname) {
        this.Tno = Tno;
        this.Tname = Tname;
        this.age = age;
        this.Cname = Cname;
    }

    /**
     * 获取
     * @return Tno
     */
    public String getTno() {
        return Tno;
    }

    /**
     * 设置
     * @param Tno
     */
    public void setTno(String Tno) {
        this.Tno = Tno;
    }

    /**
     * 获取
     * @return Tname
     */
    public String getTname() {
        return Tname;
    }

    /**
     * 设置
     * @param Tname
     */
    public void setTname(String Tname) {
        this.Tname = Tname;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     * @return Cname
     */
    public String getCname() {
        return Cname;
    }

    /**
     * 设置
     * @param Cname
     */
    public void setCname(String Cname) {
        this.Cname = Cname;
    }

    public String toString() {
        return "Teacher{Tno = " + Tno + ", Tname = " + Tname + ", age = " + age + ", Cname = " + Cname + "}";
    }
    @Test
    public void testTeacher(){
        Teacher teacher=new Teacher();
        TeacherService teacherService=new TeacherService();
        TeacherMain teacherMain=new TeacherMain();

    }
}
