package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.StudentOps;
import br.pucrs.engswii.beans.StudentReply;
import br.pucrs.engswii.model.Student;

@RestController
public class StudentController {
    @PostMapping("/student/register")
	public StudentReply registerStudent(@RequestBody Student student) {
		System.out.println("In registerStudent");
		StudentReply stdregreply = new StudentReply();       
		
		for (Student s : StudentOps.getInstance().getStudentRecords()) {
			if(s.getRegistrationNumber().equals(student.getRegistrationNumber())){
				System.out.println("Student already exists");
				stdregreply.setName(null);
				stdregreply.setAge(0);
				stdregreply.setRegistrationNumber(null);
				stdregreply.setRegistrationStatus("Student already exists");
				return stdregreply;
			}
		}

		StudentOps.getInstance().add(student);
		//We are setting the below value just to reply a message back to the caller
		stdregreply.setName(student.getName());
		stdregreply.setAge(student.getAge());
		stdregreply.setRegistrationNumber(student.getRegistrationNumber());
		stdregreply.setRegistrationStatus("Successful");

		return stdregreply;
	}

    @GetMapping("/student/list")
	public List<Student> getAllStudents() {
		return StudentOps.getInstance().getStudentRecords();
	}

    @DeleteMapping("/student/delete/{regdNum}")
	public String deleteStudentRecord(@PathVariable("regdNum") String regdNum) {
		System.out.println("In deleteStudentRecord");   
		return StudentOps.getInstance().deleteStudent(regdNum);
	}

    @PutMapping("/student/update")
	public String updateStudentRecord(@RequestBody Student stdn) {
		System.out.println("In updateStudentRecord");   
		return StudentOps.getInstance().upDateStudent(stdn);
	}

	@GetMapping("/student/find/{regdNum}")
	public Student getStudent(@PathVariable("regdNum") String regdNum) {
		System.out.println("In getStudentRecord");   
		return StudentOps.getInstance().findStudent(regdNum);
	}
}
