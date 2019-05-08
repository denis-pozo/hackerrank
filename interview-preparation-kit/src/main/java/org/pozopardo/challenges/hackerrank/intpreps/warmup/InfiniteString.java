package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InfiniteString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        if(s.equals("")) { return 0; }
        if(s.length() == 1 && s.equals("a")) { return n; }

        long aInS = countNumberOfAsStream(s);
        if(aInS == 0) { return 0; }
        if(aInS == s.length()) { return n; }

        long fullStrings = (n / s.length());
        int lengthLast = Math.toIntExact(n % s.length());
        long aInLeftover = countNumberOfAsStream(s.substring(0, lengthLast));
        return aInS * fullStrings + aInLeftover;
    }

    private static long countNumberOfAsRegex(String s) {
        long as = 0;

        Pattern pattern = Pattern.compile("[^a]*a");
        Matcher matcher = pattern.matcher("s");
        while(matcher.find()) {
            as++;
        }
        return as;
    }

    private static long  countNumberOfAsStream(String s) {
        long count = s.chars().filter(ch -> ch == 'a').count();
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
