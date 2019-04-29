package org.pozopardo.challenges.hackerrranck.strings;

import java.util.Scanner;

public class Anagrams {

    static boolean isAnagram(String a, String b) {

        if(a.length() != b.length()) {
            return false;
        }

        for (Character character : a.toCharArray()) {
            if (countAppearances(character, a) != countAppearances(character, b)){
               return false;
            }
        }

        return true;
    }

    private static int countAppearances(Character character, String a) {
        int counter = 0;
        for(Character as : a.toLowerCase().toCharArray()) {
           if(as == Character.toLowerCase(character)) {
               counter ++;
           }
        }
        return counter;
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
