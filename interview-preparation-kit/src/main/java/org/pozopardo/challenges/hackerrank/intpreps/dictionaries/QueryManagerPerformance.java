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

    static List<Integer> freqQuery(int [][] queries) {
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

        for(int [] query : queries) {
            if(operation == 3 && query[0] == 3 && value == query[1]) {
                result.add(prevRes);
            } else {
                operation = query[0];
                value = query[1];

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
        long startTimeTotal = System.currentTimeMillis();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream))){
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            int[][] queries = new int[q][2];
            for(int i = 0 ; i < q ; i++) {
                String [] query = bufferedReader.readLine().split(" ");
                queries[i][0] = Integer.parseInt(query[0]);
                queries[i][1] = Integer.parseInt(query[1]);
            }

            long startTimeMethod = System.currentTimeMillis();
            List<Integer> ans = freqQuery(queries);
            long endTimeMethod = System.currentTimeMillis();

            bufferedWriter.write(
                    ans.stream()
                            .map(Object::toString)
                            .collect(joining("\n"))
                            + "\nDuration Total: " + (System.currentTimeMillis()-startTimeTotal) + "\n"
                            + "Duration Method: " + (endTimeMethod-startTimeMethod) + "\n");

            bufferedWriter.close();
        }
    }
}
