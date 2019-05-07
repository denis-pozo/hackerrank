package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HikingAssistant {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int level = 0;
        int valleys = 0;

        for(Character c : s.toCharArray()) {
            int nextStep = c.equals('D') ? -1 : 1;
            if(level < 0 && level + nextStep == 0) valleys ++;
            level = level + nextStep;
        }

        return valleys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}

