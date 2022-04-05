package com.school.core.domain.student;

public class Telephone {
    private String number;

    public Telephone(String number) {
        if (number == null || !number.matches(
                "^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])[0-9]{3}\\-?[0-9]{4}$")) {
            throw new IllegalArgumentException("Telephone invalid");
        }
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
