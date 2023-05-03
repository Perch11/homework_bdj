package com.bdg.homework_xml_json.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "students")
public class ListStudent {

    private List<StudentWithoutMarks> students = new ArrayList<>();
    private List<Student> studentsFull = new ArrayList<>();


    @XmlElement(name = "student")
    public List<StudentWithoutMarks> getStudents() {
        return students;
    }

    public void setStudents(List<StudentWithoutMarks> students) {
        this.students = students;
    }

    @XmlElement(name = "student")
    public List<Student> getStudentsFull() {
        return studentsFull;
    }

    public void setStudentsFull(List<Student> studentsFull) {
        this.studentsFull = studentsFull;
    }

    @Override
    public String toString() {
        return "ListStudent{" +
                "students=" + students +
                '}';
    }
}
