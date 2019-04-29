package org.pozopardo.challenges.hackerrank.twilio.challenge.test;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class Solution {

        static String findNumber(List<Integer> arr, int k) {

            if(arr.contains(Integer.valueOf(k))){
                return "YES";
            }
            return "NO";
        }

        public static void main(String[] args) throws IOException {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> arrTemp = new ArrayList<>();

                IntStream.range(0, arrCount).forEach(i -> {
                        try {
                                arrTemp.add(bufferedReader.readLine().replaceAll("\\s+$", ""));
                        } catch (IOException ex) {
                                throw new RuntimeException(ex);
                        }
                });

                List<Integer> arr = arrTemp.stream()
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .collect(toList());

                int k = Integer.parseInt(bufferedReader.readLine().trim());

                String res = findNumber(arr, k);

                System.out.println(res);
//                bufferedWriter.write(res);
//                bufferedWriter.newLine();

                bufferedReader.close();
//                bufferedWriter.close();
        }
}
