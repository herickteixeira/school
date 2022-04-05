package com.school.core.domain.student;

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
    void shouldAddTwoPhones(){
        this.student.addTelephone("11 222222222");
        this.student.addTelephone("33 222222222");
        assertEquals(2, this.student.getTelephones().size());
    }

    @Test
    void shouldntAddTreePhones(){
        assertThrows(IllegalArgumentException.class, () -> {
            this.student.addTelephone("11 222222222");
            this.student.addTelephone("33 222222222");
            this.student.addTelephone("44 222222222");
        });
    }
}