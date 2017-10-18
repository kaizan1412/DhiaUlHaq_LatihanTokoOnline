/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dear.shop.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


/**
 *
 * @author user
 */
public class PasswordDigest {

    public static String createEncryptedassword(String passwordToHash) {

        String generatePassword = null;
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            System.out.println("byte digest :" + Arrays.toString(bytes));
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {

                sb.append(Integer.toString(
                        (bytes[i] & 0xff)
                        + 0x100, 16)
                        .substring(1)
                        );

            }
            generatePassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {

            e.printStackTrace();
        }
        return generatePassword;
    }

}
