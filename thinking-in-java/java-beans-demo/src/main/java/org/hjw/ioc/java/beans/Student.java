package org.hjw.ioc.java.beans;

/**
 * @ClassName Student
 * @Description TODO
 * @Author H_jw
 * @Date 2022-08-22 0022 下午 12:04
 * @Version 1.0
 */
public class Student extends Person{

    private Integer studentId;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                "} " + super.toString();
    }
}
