package org.pozopardo.hackerrank.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagrams2 {

    static boolean isAnagram(String a, String b) {
        Map<Character, Integer> appearancesA = new HashMap<>();
        Map<Character, Integer> appearancesB = new HashMap<>();

        appearancesA = getNumberOfAppearances(a);
        appearancesB = getNumberOfAppearances(b);

        for(Map.Entry<Character, Integer> aEntry : appearancesA.entrySet()) {
            if(aEntry.getValue() != appearancesB.get(aEntry.getKey())){
                return false;
            }
        }

        return true;
    }

    private static Map<Character,Integer> getNumberOfAppearances(String charset) {
        Map<Character, Integer> appearances = new HashMap<>();
        for(Character character : charset.toCharArray()) {
            if(appearances.containsKey(character)){
                appearances.put(character, appearances.get(character) + 1);
            } else {
                appearances.put(character, 1);
            }
        }
        return appearances;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
