package br.pucrs.engswii.model;

import java.util.List;

public class Course {
    private String codcred;
    private String description;
    private String classNum;
    private List<Student> students = null;

    public String getCodcred() {
        return codcred;
    }

    public void setCodcred(String codcred) {
        this.codcred = codcred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}