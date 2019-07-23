package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class QueryManagerPerformance {

    private static final int INSERT = 1;
    private static final int DELETE = 2;
    private static final int CHECK = 3;

    // Complete the freqQuery function below.

    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numbers = new HashMap<>();
        Map<Integer, Integer> frequencies = new HashMap<>();

        int operation = 0;
        int value = -1;
        int prevRes = -1;
        Integer oldFreq;
        Integer newFreq;
        Integer oldOccurrence;
        Integer newOccurrence;

        for(List<Integer> query : queries) {
            if(operation == 3 && query.get(0) == 3 && value == query.get(1)) {
                result.add(prevRes);
            } else {
                operation = query.get(0);
                value = query.get(1);

                if (operation == 3) {
                    prevRes = frequencies.get(value) == null ? 0 : 1;
                    result.add(prevRes);

                } else if ((operation == 2 && numbers.containsKey(value)) || operation == 1) {
                    oldFreq = numbers.get(value);
                    oldFreq = oldFreq == null ? 0 : oldFreq;
                    oldOccurrence = frequencies.get(oldFreq);
                    oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

                    if (operation == 1) {
                        newFreq = oldFreq + 1;
                    } else {
                        newFreq = oldFreq - 1;
                    }

                    newOccurrence = frequencies.get(newFreq);
                    newOccurrence = newOccurrence == null ? 0 : newOccurrence;

                    if (newFreq < 1) {
                        numbers.remove(value);
                    } else {
                        numbers.put(value, newFreq);
                    }

                    if ((oldOccurrence - 1) < 1) {
                        frequencies.remove(oldFreq);
                    } else {
                        frequencies.put(oldFreq, oldOccurrence - 1);
                    }
                    frequencies.put(newFreq, newOccurrence + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "/query-manager-case13.txt";
        InputStream fileStream = QueryManagerPerformance.class.getResourceAsStream(fileName);
        long startTime = System.currentTimeMillis();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\nDuration: " + (System.currentTimeMillis()-startTime) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
