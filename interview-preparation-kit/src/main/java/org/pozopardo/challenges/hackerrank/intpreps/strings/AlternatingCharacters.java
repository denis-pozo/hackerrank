package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class AlternatingCharacters {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char [] sArray = s.toCharArray();
        boolean isA = sArray[0] == 'A';
        int deletions = 0;

        for ( int i = 1 ; i < sArray.length ; i ++ ) {
            if (isA) {
                if( sArray[i] == 'B') isA = false;
                else deletions++;
            } else {
                if( sArray[i] == 'A') isA = true;
                else deletions++;
            }
        }

        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
