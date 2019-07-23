package org.pozopardo.challenges.hackerrank.intpreps.dictionaries;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
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
//        static List<Integer> freqQuery(int [][] queries) {
        List<Integer> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        HashMap<Integer, Function<Integer, Boolean>> mapa = new HashMap<>();
        mapa.put(1, o -> data.add(o));
        mapa.put(2, o -> data.remove(o));
        mapa.put(3, o -> {
            Map<Integer, Long> counts = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            return result.add(counts.containsValue(new Long(o))? 1:0);
        });
        queries.forEach(integers -> {
            mapa.get(integers.get(0)).apply(integers.get(1));
        });
        return  result;

//        List<Integer> result = new ArrayList<>();
//        Map<Integer, Integer> numbers = new HashMap<>();
//        Map<Integer, Integer> frequencies = new HashMap<>();
//        int operation = 0;
//        int value = -1;
//        int prevRes = -1;
//        Integer oldFreq;
//        Integer newFreq;
//        Integer oldOccurrence;
//        Integer newOccurrence;
//
//        for(int [] query : queries) {
//            if(query[1] < 1 || query[1] > 1000000000) {
//                System.out.println("Hello");
//            } else {
//                if(operation == 3 && query[0] == 3 && value == query[1]) {
//                    result.add(prevRes);
//                } else {
//                    operation = query[0];
//                    value = query[1];
//
//                    if (operation == 3) {
//                        prevRes = frequencies.get(value) == null ? 0 : 1;
//                        result.add(prevRes);
//
//                    } else if ((operation == 2 && numbers.containsKey(value)) || operation == 1) {
//                        oldFreq = numbers.get(value);
//                        oldFreq = oldFreq == null ? 0 : oldFreq;
//                        oldOccurrence = frequencies.get(oldFreq);
//                        oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;
//
//                        if (operation == 1) {
//                            newFreq = oldFreq + 1;
//                        } else {
//                            newFreq = oldFreq - 1;
//                        }
//
//                        newOccurrence = frequencies.get(newFreq);
//                        newOccurrence = newOccurrence == null ? 0 : newOccurrence;
//
//                        if (newFreq < 1) {
//                            numbers.remove(value);
//                        } else {
//                            numbers.put(value, newFreq);
//                        }
//
//                        if ((oldOccurrence - 1) < 1) {
//                            frequencies.remove(oldFreq);
//                        } else {
//                            frequencies.put(oldFreq, oldOccurrence - 1);
//                        }
//                        frequencies.put(newFreq, newOccurrence + 1);
//                    }
//                }
//            }
//        }
//        return result;

//        Map<Integer, Integer> operationsMap = new HashMap();
//        Map<Integer, Set<Integer>> frequenciesMap = new HashMap<>();
//
//        for(int[] query : queries) {
//            int operation = query[0];
//            int value = query[1];
//
//            switch (operation) {
//                case INSERT:
//                    Integer m = operationsMap.get(value);
//                    if( m == null) {
//                        operationsMap.put(value, 1);
//                        Set<Integer> sampleMap = frequenciesMap.get(1);
//                        if(sampleMap != null) {
//                            sampleMap.add(value);
//                        } else {
//                            frequenciesMap.put(1, new HashSet(){
//                                { add(value); }
//                            });
//                        }
//                    } else {
//                        operationsMap.put(value, ++m);
//                        frequenciesMap.get(m - 1).remove(value);
//                        Set<Integer> sampleMap = frequenciesMap.get(m);
//                        if(sampleMap != null) sampleMap.add(value);
//                        else {
//                            frequenciesMap.put(m, new HashSet() {
//                                { add(value); }
//                            });
//                        }
//                    }
//                    break;
//
//                case DELETE:
//                    Integer n = operationsMap.get(value);
//                    if(n == null) break;
//                    else if(n == 1) {
//                        operationsMap.remove(value);
//                        frequenciesMap.get(1).remove(value);
//                    } else {
//                        operationsMap.put(value, --n);
//                        frequenciesMap.get(n + 1).remove(value);
//                        Set<Integer> sampleMap = frequenciesMap.get(n);
//                        if(sampleMap != null)
//                            sampleMap.add(value);
//                        else {
//                            frequenciesMap.put(n, new HashSet() {
//                                { add(value); }
//                            });
//                        }
//                    }
//                    break;
//
//                case CHECK:
//                    result.add((frequenciesMap.get(value) == null || frequenciesMap.get(value).isEmpty()) ? 0 : 1);
//                    break;
//            }
//        }

    }

    public static void main(String[] args) throws IOException {
        String fileName = "/query-manager-case13.txt";
        InputStream fileStream = QueryManagerPerformance.class.getResourceAsStream(fileName);
        long startTimeTotal = System.currentTimeMillis();

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
