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

public class GeometricProgression {

    // Complete the countTriplets function below.
    // This algorithm is O(nlogn)
    static long countTriplets(List<Long> arr, long r) {
        if(arr.size() < 3) return 0;

        long count = 0;
        Map<Long, Long> possibleTriplets = new HashMap<>();
        Map<Long, Long> possibleDuplets = new HashMap<>();

        for(Long number : arr) {

            if(possibleTriplets.containsKey(number)){
                count = count + possibleTriplets.get(number);
            }

            if(possibleDuplets.containsKey(number)) {
                long aux = possibleDuplets.get(number);
                if(possibleTriplets.containsKey(number * r))
                    possibleTriplets.put(number * r, possibleTriplets.get(number * r) + aux);
                else
                    possibleTriplets.put(number * r, aux);
            }

            if(possibleDuplets.containsKey(number * r)){
                possibleDuplets.put(number * r, possibleDuplets.get(number * r) + 1);
            } else {
                possibleDuplets.put(number * r, 1L);
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();
    }
}
