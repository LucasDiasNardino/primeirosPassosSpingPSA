package br.pucrs.engswii.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

static static @Getter
@Setter
public class CourseReg {
    private String codcred;
    private String description;
    private String classNum;
    private List<Student> students = new ArrayList<>();
}