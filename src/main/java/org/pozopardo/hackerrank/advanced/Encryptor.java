package org.pozopardo.hackerrank.advanced;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Encryptor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String line = in.nextLine();

        try {
            byte [] bytesOfLine = line.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestLine = md.digest(bytesOfLine);
            System.out.println(bytesToHex(digestLine));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        in.close();
    }

    private static String bytesToHex(byte[] digestLine) {
        StringBuilder sb = new StringBuilder();
        for(byte b : digestLine) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}


