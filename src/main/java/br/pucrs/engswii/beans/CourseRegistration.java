package br.pucrs.engswii.beans;

import java.util.List;
import java.util.ArrayList;

public class CourseRegistration {
    
    private List<Course> courseRecords;

    private static CourseRegistration cr = null;

    private CourseRegistration(){
        courseRecords = new ArrayList<Course>();
    }

    private static CourseRegistration getInstance() {

        if(cr == null) {
            cr = new CourseRegistration();
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
}
