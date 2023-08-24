package br.pucrs.engswii.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

    private String name;
    private int age;
    private String registrationNumber;
	private String address;
    private List<Course> courses = new ArrayList<>();    
}
