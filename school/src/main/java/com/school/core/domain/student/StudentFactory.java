package com.school.core.domain.student;

public class StudentFactory {
    private Student student;

    public StudentFactory createStudentNameEmailCpf(String name, String email, String cpf) {
        this.student = new Student(name, new Email(email), new Cpf(cpf));
        return this;
    }

    public StudentFactory addStudentNumber(String number) {
        this.student.addPhone(number);
        return this;
    }

    public Student create() {
        return this.student;
    }
}
