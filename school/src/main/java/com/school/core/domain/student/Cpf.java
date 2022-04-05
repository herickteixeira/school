package com.school.core.domain.student;

public class Cpf {

    private String cpf;

    public Cpf(String cpf) {
        if (cpf == null || !cpf.matches("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9][2]")) {
            throw new IllegalArgumentException("CPF invalid");
        }
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
