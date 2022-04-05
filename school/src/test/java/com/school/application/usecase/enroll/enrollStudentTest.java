package com.school.application.usecase.enroll;

import com.school.core.domain.student.Cpf;
import com.school.core.domain.student.Student;
import com.school.infrastructure.student.StudentRepository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class enrollStudentTest {

    private final Connection connection;

    enrollStudentTest(Connection connection) {
        this.connection = connection;
    }

    @Test
    void shouldCreateStudent(){
        //MOCK -> MOCKITO
        var repository = new StudentRepository(connection);
        var enrollStudent = new EnrollStudent(repository);

        EnrollStudentDto enrollStudentDto = new EnrollStudentDto("Maria", "maria@gmail.com", "111.111.111-11");
        enrollStudent.execute(enrollStudentDto);

        Student foundStudent = repository.getByCpf(new Cpf("111.111.111-11"));
        assertNotNull(foundStudent);
        assertEquals("Maria", foundStudent.getName());
        assertEquals("maria@gmail.com", foundStudent.getEmail());
        assertEquals("111.111.111-11", foundStudent.getCpf());
    }
}