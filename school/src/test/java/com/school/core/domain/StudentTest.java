package com.school.core.domain;

import com.school.core.domain.student.Cpf;
import com.school.core.domain.student.Email;
import com.school.core.domain.student.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void beforeEach(){
        this.student = new Student(
                "Maria",
                new Email("maria@gmail.com"),
                new Cpf("111.111.111-11"));
    }
    @Test
    void shouldAddOnePhone(){
        this.student.addPhone("55 222222222");
        assertEquals(1, this.student.getPhones().size());
    }
    @Test
    void shouldAddTwoPhones(){
        this.student.addPhone("11 222222222");
        this.student.addPhone("33 222222222");
        assertEquals(2, this.student.getPhones().size());
    }

    @Test
    void shouldntAddTreePhones(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.student.addPhone("11 222222222");
            this.student.addPhone("33 222222222");
            this.student.addPhone("44 222222222");
        });
    }
}