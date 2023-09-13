package br.pucrs.engswii.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.pucrs.engswii.model.Course;


public interface CourseRepository extends MongoRepository<Course, String>{
    
}
