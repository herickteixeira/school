package com.school.core.domain.student.interfaces;

import com.school.core.domain.student.Cpf;
import com.school.core.domain.student.Student;

import java.util.List;

public interface IStudentRepository {
    void save(Student student);

    Student getByCpf(Cpf cpf);

    List<Student> getStudentList();
}
