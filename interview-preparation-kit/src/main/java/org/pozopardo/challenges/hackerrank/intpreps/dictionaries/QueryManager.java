package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QueryManager {

    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int CHECK = 3;

    // Complete the freqQuery function below.

    static List<Integer> freqQuery(List<int[]> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numbers = new HashMap<>();
        Map<Integer, Boolean> frequencies = new HashMap<>();


        for(int[] query : queries) {
            int operation = query[0];
            int value = query[1];

            switch (operation) {
                case INSERT:
                    int current = 0;
                    if(numbers.containsKey(value)) {
                        current = numbers.get(value);
                    }
                    numbers.put(value, ++current);
                    frequencies.put(current, true);
                    break;
                case DELETE:
                    if(numbers.containsKey(value)) {
                        current = numbers.get(value);
                        if (current <= 1) {
                            numbers.remove(value);
                            if(!numbers.values().contains(current)) {
                                frequencies.put(current, false);
                            }
                        }
                        else numbers.put(value, --current);
                    }
                    break;
                case CHECK:
                    if(frequencies.containsKey(value)) result.add(frequencies.get(value) ? 1 : 0);
                    else result.add(0);
                    break;
                default:
                    break;
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            List<int[]> queries = new ArrayList<>(q);
            Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
            for (int i = 0; i < q; i++) {
                int[] query = new int[2];
                Matcher m = p.matcher(bufferedReader.readLine());
                if (m.matches()) {
                    query[0] = Integer.parseInt(m.group(1));
                    query[1] = Integer.parseInt(m.group(2));
                    queries.add(query);
                }
            }

            List<Integer> ans = freqQuery(queries);

            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
                bufferedWriter.write(
                        ans.stream()
                                .map(Object::toString)
                                .collect(joining("\n"))
                                + "\n");
            }
        }
    }
}
