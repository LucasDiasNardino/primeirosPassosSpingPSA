package br.pucrs.engswii.beans;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.CourseReg;
import br.pucrs.engswii.model.Register;
import br.pucrs.engswii.model.Student;
import br.pucrs.engswii.model.StudentReg;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RegisterOps {

    private static List<CourseReg> courseRegisters = new ArrayList<>();
    private static List<StudentReg> studentRegisters = new ArrayList<>();

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
                    }
                }
                return invalidCourse(register);
            }
        }
        return invalidStudent(register);
    }

    public static RegisterReply registerOk(Register register) {
        RegisterReply registerReply = new RegisterReply();

        Student student = StudentOps.getInstance().findStudent(register.getStudentNumber());
        Course course = CourseOps.getInstance().findCourse(register.getCodCred());

        CourseReg courseReg = new CourseReg();
        courseReg.setCodcred(course.getCodcred());
        courseReg.setDescription(course.getDescription());
        courseReg.setClassNum(course.getClassNum());
        courseReg.getStudents().add(student);
        RegisterOps.courseRegisters.add(courseReg);

        StudentReg studentReg = new StudentReg();
        studentReg.setRegistrationNumber(student.getRegistrationNumber());
        studentReg.setName(student.getName());
        studentReg.setAge(student.getAge());
        studentReg.getCourses().add(course);
        RegisterOps.studentRegisters.add(studentReg);

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

    public static List<Course> getStudentCourses(String num) {
        for ( StudentReg student : RegisterOps.studentRegisters) {
            if (student.getRegistrationNumber().equals(num)) {
                return student.getCourses();
            }

        }
        System.out.println("Student not found");
        return null;

    }
}
