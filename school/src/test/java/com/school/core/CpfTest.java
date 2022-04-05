package com.school.core;

import com.school.core.domain.student.Cpf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CpfTest {

    @Test
    void shouldNotCreateInvalidCpf() {
        assertThrows(IllegalArgumentException.class, () -> new Cpf(null));
        assertThrows(IllegalArgumentException.class, () -> new Cpf(""));
        assertThrows(IllegalArgumentException.class, () -> new Cpf("qqq"));
    }

    @Test
    void shouldCreateValidCpf() {
        var cpf = new Cpf("111.111.111-11");
        assertNotNull(cpf);
        assertEquals("111.111.111-11", cpf.getCpf());
    }
}