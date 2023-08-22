package br.pucrs.engswii.model;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private String name;
    private int age;
    private String registrationNumber;

	@Embedded
	private Address address;
    
}
