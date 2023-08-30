package br.pucrs.engswii.beans;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.Register;
import br.pucrs.engswii.model.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class RegisterOps {

    private static Map<Course, List<Student>> alunosPorCurso = new HashMap<>();
    private static Map<Student, List<Course>>  matriculasAlunos = new HashMap<>();

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

        List<Student> alunosMatriculados = alunosPorCurso.getOrDefault(course, new ArrayList<>());
        alunosMatriculados.add(student);
        alunosPorCurso.put(course, alunosMatriculados);

        // Adicionar curso à lista de cursos matriculados pelo aluno
        List<Course> cursosMatriculados = matriculasAlunos.getOrDefault(student, new ArrayList<>());
        cursosMatriculados.add(course);
        matriculasAlunos.put(student, cursosMatriculados);

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
        Student student = StudentOps.getInstance().findStudent(num);
        return matriculasAlunos.getOrDefault(student, new ArrayList<>());

    }

    public static List<Student> getCourseStudents(String codCred) {
        Course course = CourseOps.getInstance().findCourse(codCred);
        return alunosPorCurso.getOrDefault(course, new ArrayList<>());
    }
}
