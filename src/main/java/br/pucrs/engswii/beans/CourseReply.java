package br.pucrs.engswii.beans;

import java.util.List;

import br.pucrs.engswii.model.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseReply {
    String codcred;
    String description;
    String classNum;
    String registrationNum;
    String registrationStatus; 
}