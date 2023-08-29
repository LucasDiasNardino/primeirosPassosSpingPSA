package br.pucrs.engswii.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentReg {
    private String name;
    private int age;
    private String registrationNumber;
	private String address;
    private List<Course> courses = new ArrayList<>(); 
}
