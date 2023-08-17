package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Course;
import br.pucrs.engswii.beans.CourseRegistrationReply;

@RestController
public class CourseRegistrationController {
    
    @PostMapping("/register/course")
    public CourseRegistrationReply registerCourse(@RequestBody Course course){
        System.out.println("In registerCourse");
        CourseRegistrationReply courseRegReply = new CourseRegistrationReply();
        courseRegReply.setCodcred(course.getCodcred());
        courseRegReply.setDescription(course.getDescription());
        courseRegReply.setClassNum(course.getClassNum());
        courseRegReply.setRegistrationNum("123456");
        courseRegReply.setRegistrationStatus("Successful");
        return courseRegReply;
    }
}