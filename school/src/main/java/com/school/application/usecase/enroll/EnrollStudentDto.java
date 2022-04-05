package com.school.application.usecase.enroll;

import com.school.core.domain.student.Cpf;
import com.school.core.domain.student.Email;
import com.school.core.domain.student.Student;

public class EnrollStudentDto {
    private String name;
    private String email;
    private String cpf;

    public EnrollStudentDto(String name, String email, String cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public Student createStudent(){
        return new Student(
                name,
                new Email(email),
                new Cpf(cpf));
    }
}
