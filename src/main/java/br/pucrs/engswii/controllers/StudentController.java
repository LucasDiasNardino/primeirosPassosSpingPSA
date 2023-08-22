package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.StudentRegistration;
import br.pucrs.engswii.beans.StudentRegistrationReply;
import br.pucrs.engswii.model.Student;

@RestController
public class StudentController {
    @PostMapping("/student/register")
	public StudentRegistrationReply registerStudent(@RequestBody Student student) {
		System.out.println("In registerStudent");
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();           
		StudentRegistration.getInstance().add(student);
		//We are setting the below value just to reply a message back to the caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");

		return stdregreply;
	}

    @GetMapping("/student/list")
	public List<Student> getAllStudents() {
		return StudentRegistration.getInstance().getStudentRecords();
	}

    @DeleteMapping("/student/delete/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		System.out.println("In deleteStudentRecord");   
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}

    @PutMapping("/student/update")
	public String updateStudentRecord(@RequestBody Student stdn) {
		System.out.println("In updateStudentRecord");   
		return StudentRegistration.getInstance().upDateStudent(stdn);
	}
}
