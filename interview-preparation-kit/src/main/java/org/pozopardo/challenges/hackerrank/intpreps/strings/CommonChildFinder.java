package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class CommonChildFinder {
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        if(s1.equals(s2)) return s1.length();

        int size1 = commonChildSize(s1, s2);
        int size2 = commonChildSize(s2, s1);

        if(size1 > size2) {
            return size1;
        } else {
            return size2;
        }
        // XXX This solution does not apply when the first common character
        // does not return the biggest common child (see last test case).
        // TODO Reverse search for the next common.
    }

    private static int commonChildSize(String s1, String s2) {
        int count = 0;
        int startPos = 0;
        int nextPos = 0;

        for(char c : s1.toCharArray()) {
            nextPos = findNext(c, s2.substring(startPos));

            if (nextPos == -1) {
                continue;
            }

            startPos += nextPos + 1;
            count++;

            if (startPos == s2.length()) {
                return count;
            }
        }

        return count;
    }

    private static int findNext(char toFind, String substring) {
        char [] subArray = substring.toCharArray();

        for(int i = 0 ; i < substring.length() ; i++) {
            if(toFind == subArray[i]) {
                return i;
            }
        }

        return -1;
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
