package com.school.core.domain.student.interfaces;

public interface IEncryptPassword {
    String encryptPassword(String password);

    boolean validPasswordEncrypt(String encryptedPassword, String password);
}
