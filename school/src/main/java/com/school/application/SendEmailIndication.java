package com.school.application;

import com.school.core.domain.student.Student;

public interface SendEmailIndication {
    void send(Student student);
}
