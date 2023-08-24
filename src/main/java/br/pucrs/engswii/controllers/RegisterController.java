package br.pucrs.engswii.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.pucrs.engswii.beans.CourseOps;
import br.pucrs.engswii.beans.RegisterOps;
import br.pucrs.engswii.beans.RegisterReply;
import br.pucrs.engswii.beans.StudentOps;
import br.pucrs.engswii.model.Course;
import br.pucrs.engswii.model.Register;
import br.pucrs.engswii.model.Student;

@RestController
public class RegisterController {
    
    @PostMapping("/register/regis")
    public RegisterReply register(@RequestBody Register payload){
        return RegisterOps.register(payload);     
    }
}
