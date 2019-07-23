//package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;
//
//import java.io.*;
//import java.util.*;
//import java.util.regex.*;
//import static java.util.stream.Collectors.joining;
//
//public class QueryManager {
//
//    private static final int INSERT = 1;
//    private static final int DELETE = 2;
//    private static final int CHECK = 3;
//
//    // Complete the freqQuery function below.
//
//    static List<Integer> freqQuery(int[][] queries) {
//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer> numbers = new HashMap<>();
//        Map<Integer, Integer> frequencies = new HashMap<>();
//
//        int operation = 0;
//        int value = -1;
//        int prevRes = -1;
//        Integer oldFreq;
//        Integer newFreq;
//        Integer oldOccurrence;
//        Integer newOccurrence;
//
//        for(int[] query : queries) {
//            if(operation == 3 && query[0] == 3 && value == query[1]) {
//                result.add(prevRes);
//            } else {
//                operation = query[0];
//                value = query[1];
//
//                if (operation == 3) {
//                    prevRes = frequencies.get(value) == null ? 0 : 1;
//                    result.add(prevRes);
//
//                } else if ((operation == 2 && numbers.containsKey(value)) || operation == 1) {
//                    oldFreq = numbers.get(value);
//                    oldFreq = oldFreq == null ? 0 : oldFreq;
//                    oldOccurrence = frequencies.get(oldFreq);
//                    oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;
//
//                    if (operation == 1) {
//                        newFreq = oldFreq + 1;
//                    } else {
//                        newFreq = oldFreq - 1;
//                    }
//
//                    newOccurrence = frequencies.get(newFreq);
//                    newOccurrence = newOccurrence == null ? 0 : newOccurrence;
//
//                    if (newFreq < 1) {
//                        numbers.remove(value);
//                    } else {
//                        numbers.put(value, newFreq);
//                    }
//
//                    if ((oldOccurrence - 1) < 1) {
//                        frequencies.remove(oldFreq);
//                    } else {
//                        frequencies.put(oldFreq, oldOccurrence - 1);
//                    }
//                    frequencies.put(newFreq, newOccurrence + 1);
//                }
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws IOException {
//        long startTime = System.currentTimeMillis();
//
//        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
//            int q = Integer.parseInt(bufferedReader.readLine().trim());
//            int[][] queries = new int[q][2];
//
//            for (int i = 0; i < q; i++) {
//                String[] query = bufferedReader.readLine().split(" ");
//                queries[i][0] = Integer.parseInt(query[0]);
//                queries[i][1] = Integer.parseInt(query[1]);
//            }
//
//            List<Integer> ans = freqQuery(queries);
//
//
//            try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
//                bufferedWriter.write(
//                        ans.stream()
//                                .map(Object::toString)
//                                .collect(joining("\n"))
//                                + "\n"
//                                + "Duration: " + (System.currentTimeMillis() - startTime) + "\n");
//            }
//        }
//    }
//}
