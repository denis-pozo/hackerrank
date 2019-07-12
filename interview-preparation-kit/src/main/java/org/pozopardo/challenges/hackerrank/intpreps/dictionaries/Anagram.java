package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Anagram {

    // Complete the sherlockAndAnagrams function below.
    // This algorithm is O(n^4)
    static int sherlockAndAnagrams(String s) {
        int count = 0;

        for(int i = 1 ; i < s.length() ; i++) {
            count += computeAnagrams(s, i);
        }

        return count;
    }

    private static int computeAnagrams(String s, int length) {
        int count = 0;
        for(int i = 0 ; i < s.length()-length ; i++) {
            String sub = s.substring(i, i+length);
            for(int j = i+1 ; j < s.length()-length+1 ; j ++) {
                if(areAnagrams(sub, s.substring(j, j+length))) count++;
            }
        }

        return count;
    }

    private static boolean areAnagrams(String sub1, String sub2) {
        if(sub1.length() != sub2.length()) return false;
        List<Character> sub1List = new ArrayList<>(sub1.length());

        for(Character c : sub1.toCharArray()) {
            sub1List.add(c);
        }

        for(Character c : sub2.toCharArray()) {
            if(sub1List.contains(c)) sub1List.remove(c);
            else return false;
        }

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }

        scanner.close();
    }
}
