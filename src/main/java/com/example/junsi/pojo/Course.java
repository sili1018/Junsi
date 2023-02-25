package com.example.junsi.pojo;

import java.util.Collection;
import lombok.Data;
@Data
public class Course {
    private String cno;
    private String Cname;
    private String Tname;


    public Course() {
    }

    public Course(String cno, String Cname, String Tname) {
        this.cno = cno;
        this.Cname = Cname;
        this.Tname = Tname;
    }

    /**
     * 获取
     * @return cno
     */
    public String getCno() {
        return cno;
    }

    /**
     * 设置
     * @param cno
     */
    public void setCno(String cno) {
        this.cno = cno;
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

    public String toString() {
        return "Course{cno = " + cno + ", Cname = " + Cname + ", Tname = " + Tname + "}";
    }


}
