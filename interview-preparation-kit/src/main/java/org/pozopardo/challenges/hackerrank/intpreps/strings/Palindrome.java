package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Palindrome {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        char [] sArray = s.toCharArray();
        int count = 0;

        for(int length = 1 ; length <= n ; length++) {
            count += countPalindromes(sArray, length);
        }

        return count;
    }

    private static int countPalindromes(char[] sArray, int length) {
        if (length == 1) return sArray.length;

        int count = 0;
        Deque<Character> list = new LinkedList<>();
        int i;
        for(i = 0 ; i < length ; i++) {
            list.add(sArray[i]);
        }
        if(isSpecial(list)) count++;
        if(sArray.length == length) return count;

        do {
            list.add(sArray[i++]);
            list.removeFirst();
            if(isSpecial(list)) count++;
        } while (i < sArray.length);

        return count;
    }

    private static boolean isSpecial(Deque<Character> subString) {
        Deque<Character> copy = new LinkedList<>(subString);
        char first = copy.getFirst();
        while(copy.size() > 1) {
            if (copy.removeFirst() != first || copy.removeLast() != first) return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

