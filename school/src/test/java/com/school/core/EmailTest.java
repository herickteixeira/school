package com.school.core;

import com.school.core.domain.student.Email;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void shouldNotCreateInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));
        assertThrows(IllegalArgumentException.class, () -> new Email(""));
        assertThrows(IllegalArgumentException.class, () -> new Email("qqq"));
    }

    @Test
    void shouldCreateValidEmail() {
        var email = new Email("uehduhe@gmail.com");
        assertNotNull(email);
        assertEquals("uehduhe@gmail.com", email.getEmail());
    }
}