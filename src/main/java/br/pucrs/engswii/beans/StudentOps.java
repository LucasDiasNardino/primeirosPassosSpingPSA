package br.pucrs.engswii.beans;

import java.util.ArrayList;
import java.util.List;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.Student;

public class StudentOps {

	private List<Student> studentRecords;

	private static StudentOps stdregd = null;

	private StudentOps(){
		studentRecords = new ArrayList<Student>();
	}

	public static StudentOps getInstance() {

		if(stdregd == null) {
			stdregd = new StudentOps();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}

	public void add(Student std) {
		studentRecords.add(std);
	}

	public String upDateStudent(Student std) {

		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(std.getRegistrationNumber())) {
				studentRecords.set(i, std);//update the new record
				return "Update successful";
			}
		}

		return "Update un-successful";
	}

	public String deleteStudent(String registrationNumber) {

		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getRegistrationNumber().equals(registrationNumber)){
				studentRecords.remove(i);//update the new record
				return "Delete successful";
			}
		}

		return "Delete un-successful";
	}

	public List<Student> getStudentRecords() {
		return studentRecords;
	}

    public Student findStudent(String num) {       
		for (Student student : studentRecords) {
			if(student.getRegistrationNumber().equals(num)){
				System.out.println("Student found");
				return student;
			}
		}

		System.out.println("Student not found");
        return null;
    }

    public List<Student> findStudentByName(String name) {
		List<Student> matches = new ArrayList<Student>();

		for (Student student : studentRecords) {
			if(student.getName().contains(name)){
				matches.add(student);
			}
		}

		if(matches.size() == 0) {
			System.out.println("No students found");
		}

		return matches;
    }

}