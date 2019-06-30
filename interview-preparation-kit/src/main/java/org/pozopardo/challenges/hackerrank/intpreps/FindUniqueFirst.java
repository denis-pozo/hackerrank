package org.pozopardo.challenges.hackerrank.intpreps;

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
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String inputStr = scanner.next();

        Character res = findFirstUniqueCharacter(inputStr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
