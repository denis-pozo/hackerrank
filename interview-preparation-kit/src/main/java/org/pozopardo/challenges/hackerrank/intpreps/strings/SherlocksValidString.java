package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SherlocksValidString {

    // Complete the isValid function below.
    // This algorithm has a time complexity of O(n)
    static String isValid(String s) {
        Map<Character, Integer> charOccurrences = new HashMap<>();

        for(Character c : s.toCharArray()) {
            if(charOccurrences.containsKey(c)) charOccurrences.put(c, charOccurrences.get(c) + 1);
            else charOccurrences.put(c, 1);
        }

        Iterator<Integer> occurrences = charOccurrences.values().iterator();
        int occurrencesA = occurrences.next();
        int countA = 1;
        int occurrencesB = 0;
        int countB = 0;
        while (occurrences.hasNext()) {
            int n = occurrences.next();
            if (n == occurrencesA) {
                countA++;
            } else if (n == occurrencesB){
                countB++;
            } else if (occurrencesB == 0) {
                occurrencesB = n;
                countB = 1;
            }
            if(countA > 1 && countB > 1) return "NO";
            if (n != occurrencesA && n != occurrencesB) return "NO";
        }

        int difference = 0;
        if(occurrencesB != 0) {
            difference = Math.abs(occurrencesA - occurrencesB);
            if(countA == 1 && occurrencesA > 1 && difference > 1) return "NO";
            if(countB == 1 && occurrencesB > 1 && difference > 1) return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
