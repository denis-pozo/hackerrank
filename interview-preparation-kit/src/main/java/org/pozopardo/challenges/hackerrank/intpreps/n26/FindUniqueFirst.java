package org.pozopardo.challenges.hackerrank.intpreps.n26;

import java.io.*;
import java.text.*;
import java.util.*;

public class FindUniqueFirst {

    private static Character findFirstUniqueCharacter(String inputString) {
        // TODO implement this method
        Map<Character, Integer> frequencies = new LinkedHashMap<>();

        for(Character c : inputString.toCharArray()) {
            if(frequencies.containsKey(c)){
                frequencies.put(c, frequencies.get(c) + 1);
            } else {
                frequencies.put(c, 1);
            }
        }

        if(frequencies.size() == 0 ) {
            return null;
        }

        for(Map.Entry<Character, Integer> unrepeated : frequencies.entrySet()){
            if(unrepeated.getValue() == 1) {
                return unrepeated.getKey();
            }
         }

        return null;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String inputStr = scanner.next();

        Character res = findFirstUniqueCharacter(inputStr);

        System.out.println(res);

        scanner.close();
    }
}
