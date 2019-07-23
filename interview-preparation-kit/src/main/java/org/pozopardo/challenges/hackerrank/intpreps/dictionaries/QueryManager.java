package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class QueryManager {

    // Complete the freqQuery function below.
    // The complexity of this method is O(n)
    static List<Integer> freqQuery(BufferedReader bufferedReader, int q) throws IOException {
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

        for(int i = 0 ; i < q ; i ++) {
            String[] query = bufferedReader.readLine().split(" ");
            int newOperation = Integer.parseInt(query[0]);
            int newValue = Integer.parseInt(query[1]);

            if(operation == 3 && newOperation == 3 && value == newValue) {
                result.add(prevRes);
            } else {
                operation = newOperation;
                value = newValue;

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
        String fileName = "/query-manager-case10.txt";
        InputStream fileStream = QueryManager.class.getResourceAsStream(fileName);
        long startTimeTotal = System.currentTimeMillis();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileStream))){
            int q = Integer.parseInt(bufferedReader.readLine().trim());
            long startTimeMethod = System.currentTimeMillis();
            List<Integer> ans = freqQuery(bufferedReader, q);
            long endTimeMethod = System.currentTimeMillis();

            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
                         bufferedWriter.write(ans.stream()
                                 .map(Object::toString)
                                 .collect(joining("\n"))
                        + "\nDuration Total: " + (System.currentTimeMillis()-startTimeTotal)
                        + "\nDuration Method: " + (endTimeMethod-startTimeMethod) + "\n");
            }
        }
    }
}
