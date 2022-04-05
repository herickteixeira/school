package com.school.core;

import com.school.core.domain.student.Phone;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneTest {
    @Test
    void shouldCreateInvalidTelephone() {
        assertThrows(IllegalArgumentException.class, () -> new Phone(null));
        assertThrows(IllegalArgumentException.class, () -> new Phone(""));
        assertThrows(IllegalArgumentException.class, () -> new Phone("qqq"));
    }

    @Test
    void shouldCreateValidTelephone() {
        var tel = new Phone("51 123456789");
        assertNotNull(tel);
        assertEquals("51 123456789", tel.getNumber());
    }
}