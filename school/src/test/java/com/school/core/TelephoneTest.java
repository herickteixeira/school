package com.school.core;

import com.school.core.domain.student.Telephone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneTest {
    @Test
    void shouldCreateInvalidTelephone() {
        assertThrows(IllegalArgumentException.class, () -> new Telephone(null));
        assertThrows(IllegalArgumentException.class, () -> new Telephone(""));
        assertThrows(IllegalArgumentException.class, () -> new Telephone("qqq"));
    }

    @Test
    void shouldCreateValidTelephone() {
        var tel = new Telephone("51 123456789");
        assertNotNull(tel);
        assertEquals("51 123456789", tel.getNumber());
    }
}