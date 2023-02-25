package com.example.junsi.pojo;

public class Day {
    private String first;
    private String second;
    private String third;
    private String fourth;

    public Day() {
    }

    public Day(String first, String second, String third, String fourth) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.fourth = fourth;
    }
    public String getFirst() {
        return first;
    }

    /**
     * 设置
     * @param first
     */
    public void setFirst(String first) {
        this.first = first;
    }

    /**
     * 获取
     * @return second
     */
    public String getSecond() {
        return second;
    }

    /**
     * 设置
     * @param second
     */
    public void setSecond(String second) {
        this.second = second;
    }

    /**
     * 获取
     * @return third
     */
    public String getThird() {
        return third;
    }

    /**
     * 设置
     * @param third
     */
    public void setThird(String third) {
        this.third = third;
    }

    /**
     * 获取
     * @return fourth
     */
    public String getFourth() {
        return fourth;
    }

    /**
     * 设置
     * @param fourth
     */
    public void setFourth(String fourth) {
        this.fourth = fourth;
    }

    public String toString() {
        return "Day{first = " + first + ", second = " + second + ", third = " + third + ", fourth = " + fourth + "}";
    }
}
