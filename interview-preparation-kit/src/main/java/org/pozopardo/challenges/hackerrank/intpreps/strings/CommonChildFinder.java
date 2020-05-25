package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CommonChildFinder {
    // Complete the commonChild function below.
    // Problem known as Longest Common Subsequence LCS. O(n^2)
    static int commonChild(String s1, String s2) {
        if(s1.equals(s2)) return s1.length();

        int [][] LCS = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 1 ; i <= s1.length() ; i++) {
            for(int j = 1 ; j <= s2.length() ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    LCS[i][j] = LCS[i-1][j-1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i][j-1], LCS[i-1][j]);
                }
            }
        }

        return LCS[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }

}
