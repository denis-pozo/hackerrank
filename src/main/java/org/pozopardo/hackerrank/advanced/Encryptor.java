package org.pozopardo.hackerrank.advanced;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/* Solution for advanced challenges: 63 (MD5), 64 (SHA-256) */
public class Encryptor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        try {
            byte[] encryptedMD5 = encrypt(line, MessageDigest.getInstance("MD5"));
            byte[] encryptedSHA256 = encrypt(line, MessageDigest.getInstance("SHA-256"));
            System.out.println(bytesToHex(encryptedMD5));
            System.out.println(bytesToHex(encryptedSHA256));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        in.close();
    }

    public static byte[] encrypt(String str, MessageDigest md) throws UnsupportedEncodingException {
        byte [] result = md.digest(str.getBytes("UTF-8"));
        return result;
    }

    private static String bytesToHex(byte[] digestLine) {
        StringBuilder sb = new StringBuilder();
        for(byte b : digestLine) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


