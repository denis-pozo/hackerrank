package org.pozopardo.hackerrank.regex;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor {

    private static final Pattern PATTERN = Pattern.compile("<(.*)>(.+)</\\1>");

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        while(testCases>0){
            String line = in.nextLine();
            printInnerTagContent(line);
            testCases--;
        }
    }

    private static void printInnerTagContent(String line) {
        String result = null;
        Matcher matcherIn = PATTERN.matcher(line);

        while (matcherIn.find()){
            Matcher matcherRecursive = PATTERN.matcher(matcherIn.group(2));
            if(!matcherRecursive.matches()){
                result = matcherIn.group(2);
            } else {
                printInnerTagContent(matcherIn.group(2));
                result = "None";
            }
        }

        if(result != null) {
            System.out.println(result);
        }
    }
}

