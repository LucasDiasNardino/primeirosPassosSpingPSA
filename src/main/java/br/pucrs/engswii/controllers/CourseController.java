package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.CourseOps;
import br.pucrs.engswii.beans.CourseReply;
import br.pucrs.engswii.model.Course;

@RestController
public class CourseController {
    
   @PostMapping("/course/register")
    public CourseReply registerCourse(@RequestBody Course course){
        System.out.println("In registerCourse");
        CourseReply courseRegReply = new CourseReply();
		
        
        for (Course c : CourseOps.getInstance().getCourseRecords()) {
            if(course.getClassNum().equals(c.getClassNum())){
                System.out.println("Course already exists");
                courseRegReply.setCodcred(null);
                courseRegReply.setDescription(null);
                courseRegReply.setClassNum(null);
                courseRegReply.setRegistrationNum(null);
                courseRegReply.setRegistrationStatus("Course already registered");
                return courseRegReply;
            }
        }
        CourseOps.getInstance().add(course);
        courseRegReply.setCodcred(course.getCodcred());
        courseRegReply.setDescription(course.getDescription());
        courseRegReply.setClassNum(course.getClassNum());
        courseRegReply.setRegistrationNum("123456");
        courseRegReply.setRegistrationStatus("Successful");
        
        return courseRegReply;
    
    }

    @GetMapping("/course/list")
    public List<Course> getAllCourses() {
        return CourseOps.getInstance().getCourseRecords();
    }
    
    @PutMapping("/course/update")
	public String updateCourseRecord(@RequestBody Course course) {
		System.out.println("In updateCourseRecord");   
		return CourseOps.getInstance().upDateCourse(course);
	}

    @DeleteMapping("/course/delete/{codcred}")
    public String deleteCourseRecord(@PathVariable("codcred") String codcred) {
        System.out.println("In deleteCourseRecord");   
        return CourseOps.getInstance().deleteCourse(codcred);
    }

    @GetMapping("/course/find/{codcred}")
    public Course findCourse(@PathVariable("codcred") String codcred) {
        System.out.println("In findCourse");   
        return CourseOps.getInstance().findCourse(codcred);
    }
}
