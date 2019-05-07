package org.pozopardo.challenges.hackerrank.intpreps.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CloudsGame {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        int jumps = 0;
        int currentCloud = 0;

        do {
            if(currentCloud < c.length-2 && c[currentCloud + 2] == 0){
                currentCloud += 2;
                jumps++;
            } else if(c[currentCloud + 1] == 0) {
                currentCloud += 1;
                jumps++;
            }
        } while(currentCloud < c.length-1);

        return jumps;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}
