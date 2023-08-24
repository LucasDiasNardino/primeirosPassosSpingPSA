package br.pucrs.engswii.beans;

import java.util.List;

import br.pucrs.engswii.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentReply {

	String name;
	int age;
	String registrationNumber;
	String registrationStatus;
	List<Course> courses;
}
