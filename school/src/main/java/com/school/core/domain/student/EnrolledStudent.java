package com.school.core.domain.student;

import com.school.core.domain.student.interfaces.Event;

import java.time.LocalDateTime;

public class EnrolledStudent implements Event {

    private final Cpf cpfStudent;
    private final LocalDateTime moment;

    public EnrolledStudent(Cpf cpfStudent) {
        this.cpfStudent = cpfStudent;
        this.moment = LocalDateTime.now();
    }

    @Override
    public LocalDateTime moment() {
        return this.moment;
    }

    public Cpf getCpfStudent() {
        return cpfStudent;
    }
}
