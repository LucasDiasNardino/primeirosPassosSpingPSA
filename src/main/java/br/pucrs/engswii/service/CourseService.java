package br.pucrs.engswii.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.repository.CourseRepository;

@Service
public class CourseService {
    
    // @Autowired
    private CourseRepository courseRepository;

    public void save(Course course) {
        courseRepository.save(course);
    }
}
