package com.school.core.domain.student;

public class Email {

    private String email;

    public Email(String email) {
        if (email == null || !email.matches(
                "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$")) {
            throw new IllegalArgumentException("E-mail invalid!");
        }
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
