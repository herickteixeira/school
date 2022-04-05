package com.school.infrastructure.student;

import com.school.core.domain.student.interfaces.IEncryptPassword;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptorPasswordMD5 implements IEncryptPassword {
    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] bytes = messageDigest.digest();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < bytes.length; i++){
                stringBuilder.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return stringBuilder.toString();

        }catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generate hash password");
        }
    }

    @Override
    public boolean validPasswordEncrypt(String encryptedPassword, String password) {
        return false;
    }
}
