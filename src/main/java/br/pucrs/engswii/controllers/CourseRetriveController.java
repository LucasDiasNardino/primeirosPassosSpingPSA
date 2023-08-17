package br.pucrs.engswii.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.Course;
import br.pucrs.engswii.beans.CourseRegistration;

@RestController
public class CourseRetriveController {

    @GetMapping("/retrieve/courses")
    public List<Course> getAllCourses() {
        return CourseRegistration.getInstance().getCourseRecords();
    }
}
