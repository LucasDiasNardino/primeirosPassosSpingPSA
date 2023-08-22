package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.CourseRegistration;
import br.pucrs.engswii.beans.CourseRegistrationReply;
import br.pucrs.engswii.model.Course;

@RestController
public class CourseController {
    
   @PostMapping("/course/register")
    public CourseRegistrationReply registerCourse(@RequestBody Course course){
        System.out.println("In registerCourse");
        CourseRegistrationReply courseRegReply = new CourseRegistrationReply();
		
        
        for (Course c : CourseRegistration.getInstance().getCourseRecords()) {
            if(course.getCodcred().equals(c.getCodcred())){
                System.out.println("Course already exists");
                courseRegReply.setCodcred(null);
                courseRegReply.setDescription(null);
                courseRegReply.setClassNum(null);
                courseRegReply.setRegistrationNum(null);
                courseRegReply.setRegistrationStatus("Course already exists");
                return courseRegReply;
            }
        }
        CourseRegistration.getInstance().add(course);
        courseRegReply.setCodcred(course.getCodcred());
        courseRegReply.setDescription(course.getDescription());
        courseRegReply.setClassNum(course.getClassNum());
        courseRegReply.setRegistrationNum("123456");
        courseRegReply.setRegistrationStatus("Successful");
        
        return courseRegReply;
    
    }

    @GetMapping("/course/list")
    public List<Course> getAllCourses() {
        return CourseRegistration.getInstance().getCourseRecords();
    }
    
    @PutMapping("/course/update")
	public String updateCourseRecord(@RequestBody Course course) {
		System.out.println("In updateCourseRecord");   
		return CourseRegistration.getInstance().upDateCourse(course);
	}
}
