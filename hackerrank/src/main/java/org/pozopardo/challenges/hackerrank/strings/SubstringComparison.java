package org.pozopardo.challenges.hackerrank.strings;

public class SubstringComparison {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);

        for(int i = 0 ; i <= s.length()-k ; i++) {
            String sub = s.substring(i, i+k);
            smallest = smallest.compareTo(sub) < 0 ? smallest : sub;
            largest = largest.compareTo(sub) > 0 ? largest : sub;
            System.out.println(smallest + " " + largest);
        }

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        return smallest + "\n" + largest;
    }

    public static void main (String [] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }
}
