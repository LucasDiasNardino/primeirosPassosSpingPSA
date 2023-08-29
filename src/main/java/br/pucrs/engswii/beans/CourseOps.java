package br.pucrs.engswii.beans;

import java.util.List;

import org.apache.catalina.manager.util.SessionUtils;

import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.CourseReg;
import br.pucrs.engswii.model.Student;

import java.util.ArrayList;

public class CourseOps {
    
    private List<Course> courseRecords;

    private static CourseOps cr = null;

    private CourseOps(){
        courseRecords = new ArrayList<Course>();
    }

    public static CourseOps getInstance() {

        if(cr == null) {
            cr = new CourseOps();
            return cr;
        }
        else {
            return cr;
        }
    }

    public void add(Course c) {       
        courseRecords.add(c);
    }


    public String upDateCourse(Course c) {

        for(int i=0; i<courseRecords.size(); i++)
        {
            Course cn = courseRecords.get(i);
            if(cn.getCodcred().equals(c.getCodcred())) {
                courseRecords.set(i, c);//update the new record
                return "Update successful";
            }
        }

        return "Update un-successful";
    }

    public String deleteCourse(String codcred) {

        for(int i=0; i<courseRecords.size(); i++)
        {
            Course cn = courseRecords.get(i);
            if(cn.getCodcred().equals(codcred)){
                courseRecords.remove(i);//update the new record
                return "Delete successful";
            }
        }

        return "Delete un-successful";
    }

    public List<Course> getCourseRecords() {
        return courseRecords;
    }

    public Course findCourse(String codcred) {       
		for (Course course : courseRecords) {
			if(course.getCodcred().equals(codcred)){
				System.out.println("Course found");
				return course;
			}
		}

		System.out.println("Course not found");
        return null;
    }
}
