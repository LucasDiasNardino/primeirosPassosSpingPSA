package br.pucrs.engswii.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection="course")
public class Course {

    @Id
    private String codcred;
    private String description;
    private String classNum;
}