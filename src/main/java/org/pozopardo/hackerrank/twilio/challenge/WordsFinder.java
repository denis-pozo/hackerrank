package org.pozopardo.hackerrank.twilio.challenge;

import java.io.IOException;
import java.util.*;

public class WordsFinder {

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static List<String> missingWords(String s, String t) {
        String[] splitS = s.split(" ");
        String[] splitT = t.split(" ");

        Set<String> setS = new LinkedHashSet<>(Arrays.asList(splitS));
        Set<String> setT = new LinkedHashSet<>(Arrays.asList(splitT));
        setS.removeAll(setT);

        return new ArrayList<>(setS);
    }

    public static void main(String[] args) throws IOException {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";

        System.out.println(missingWords(s, t));
    }
}

