package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Course;
import br.pucrs.engswii.beans.CourseRegistration;
import br.pucrs.engswii.beans.CourseRegistrationReply;
import br.pucrs.engswii.beans.StudentRegistration;

@RestController
public class CourseRegistrationController {
    
    @PostMapping("/register/course")
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
}