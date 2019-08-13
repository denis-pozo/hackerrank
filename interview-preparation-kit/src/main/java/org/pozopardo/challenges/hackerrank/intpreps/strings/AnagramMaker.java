package org.pozopardo.challenges.hackerrank.intpreps.strings;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AnagramMaker {

    // Complete the makeAnagram function below.
    // This solution has a time complexity O(n)
    static int makeAnagram(String a, String b) {
        Map<Character, Integer> decomposedString = stringToMap(a);
        StringBuilder sb = new StringBuilder();

        for ( Character c : b.toCharArray() ) {
            if ( decomposedString.containsKey(c) ) {
                int freq = decomposedString.get(c);
                if(freq == 1) {
                    decomposedString.remove(c);
                } else {
                    decomposedString.put(c, --freq);
                }
                sb.append(c);
            }
        }

        String anagram = sb.toString();
        return a.length() + b.length() - 2 * anagram.length();
    }

    private static Map<Character, Integer> stringToMap(String a) {
        Map<Character, Integer> decomposedString = new HashMap<>();

        for(Character c : a.toCharArray()) {
            if (decomposedString.containsKey(c)) decomposedString.put(c, decomposedString.get(c) + 1);
            else decomposedString.put(c, 1);
        }

        return decomposedString;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
