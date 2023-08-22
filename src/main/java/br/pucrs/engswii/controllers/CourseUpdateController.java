package br.pucrs.engswii.controllers;

//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Course;
import br.pucrs.engswii.beans.CourseRegistration;
import br.pucrs.engswii.beans.Student;
import br.pucrs.engswii.beans.StudentRegistration;

@RestController
public class CourseUpdateController {
	@PutMapping("/update/course")
	public String updateCourseRecord(@RequestBody Course course) {
		System.out.println("In updateCourseRecord");   
		return CourseRegistration.getInstance().upDateCourse(course);
	}

}
