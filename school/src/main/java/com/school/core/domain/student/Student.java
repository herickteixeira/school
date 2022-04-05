package com.school.core.domain.student;

import java.util.List;

public class Student {

    private String name;
    private Email email;
    private Cpf cpf;
    private List<Telephone> telephones;
    private String password;

    public Student(String name, Email email, Cpf cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public void addTelephone(String number) {
        if (telephones.size() == 2) throw new IllegalArgumentException("Max numbers!");

        this.telephones.add(new Telephone(number));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf.getCpf();
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
