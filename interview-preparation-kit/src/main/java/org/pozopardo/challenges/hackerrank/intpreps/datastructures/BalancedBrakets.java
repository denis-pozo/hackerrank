package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBrakets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        if(s.length() % 2 != 0) {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack.push(']');

            } else if (c == '{') {
                stack.push('}');

            } else if (c == '(') {
                stack.push(')');
            } else {
                if(stack.empty()) {
                    return "NO";
                }
                if (c != stack.pop()) {
                    return "NO";
                }
            }
        }

        if(!stack.empty()) {
            return "NO";
        }
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
