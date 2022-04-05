package com.school.core.domain.student;

import java.util.List;

public class Student {

    private String name;
    private Email email;
    private Cpf cpf;
    private List<Phone> phones;
    private String password;

    public Student(String name, Email email, Cpf cpf) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
    }

    public void addPhone(String number) {
        if (phones.size() == 2) throw new IllegalArgumentException("Max numbers!");

        this.phones.add(new Phone(number));
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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setTelephones(List<Phone> phones) {
        this.phones = phones;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
