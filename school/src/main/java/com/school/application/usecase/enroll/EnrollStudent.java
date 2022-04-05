package com.school.application.usecase.enroll;

import com.school.core.domain.student.Student;
import com.school.infrastructure.student.StudentRepository;

public class EnrollStudent {
    private final StudentRepository studentRepository;

    public EnrollStudent(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(EnrollStudentDto enrollStudentDto){
        Student student = enrollStudentDto.createStudent();
        studentRepository.save(student);
    }
}
