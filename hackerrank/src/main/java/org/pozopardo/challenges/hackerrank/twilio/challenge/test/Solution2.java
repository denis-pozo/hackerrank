package org.pozopardo.challenges.hackerrank.twilio.challenge.test;

import java.io.*;
import java.util.*;
import static java.util.stream.Collectors.joining;

public class Solution2 {

    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> odds = new ArrayList<>();
        int lo = l % 2 == 0 ? l+1 : l;
        int ro = r % 2 == 0 ? r-1 : r;

        for(int i = lo ; i <= ro ; i = i+2) {
            odds.add(i);
        }

        return odds;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> res = oddNumbers(l, r);

        bufferedWriter.write(
                res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
