package br.pucrs.engswii.beans;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.Register;
import br.pucrs.engswii.model.Student;

import java.util.List;

import br.pucrs.engswii.beans.StudentOps;

public class RegisterOps {

    public static RegisterReply register(Register register) {
        String studentNumber = register.getStudentNumber();
        String codCred = register.getCodCred();
        String classNum = register.getClassNum();

        Student student = StudentOps.getInstance().findStudent(studentNumber);
        Course course = CourseOps.getInstance().findCourse(codCred);

        if (student == null) {
            return invalidStudent(register);
        }

        else if (course == null) {
            return invalidCourse(register);
        }

        for (Student s : StudentOps.getInstance().getStudentRecords()) {
            if (s.getRegistrationNumber().equals(studentNumber)) {
                for (Course c : CourseOps.getInstance().getCourseRecords()) {
                    if (c.getCodcred().equals(codCred) && c.getClassNum().equals(classNum)) {
                        return registerOk(register);
                    } else {
                        return invalidCourse(register);
                    }
                }
            } else {
                return invalidStudent(register);
            }
        }
        return null;
    }

    public static RegisterReply registerOk(Register register) {
        RegisterReply registerReply = new RegisterReply();

        Student student = StudentOps.getInstance().findStudent(register.getStudentNumber());
        Course course = CourseOps.getInstance().findCourse(register.getCodCred());

        student.getCourses().add(course);
        course.getStudents().add(student);

        registerReply.setStudentNumber(register.getStudentNumber());
        registerReply.setCodCred(register.getCodCred());
        registerReply.setClassNum(register.getClassNum());
        registerReply.setRegistrationStatus("Registered");
        return registerReply;
    }

    public static RegisterReply invalidStudent(Register register) {

        RegisterReply registerReply = new RegisterReply();
        registerReply.setStudentNumber(register.getStudentNumber());
        registerReply.setCodCred(register.getCodCred());
        registerReply.setClassNum(register.getClassNum());
        registerReply.setRegistrationStatus("Student not found");

        return registerReply;
    }

    public static RegisterReply invalidCourse(Register register) {
        RegisterReply registerReply = new RegisterReply();
        registerReply.setStudentNumber(register.getStudentNumber());
        registerReply.setCodCred(register.getCodCred());
        registerReply.setClassNum(register.getClassNum());
        registerReply.setRegistrationStatus("Course not found");
        return registerReply;
    }
}
