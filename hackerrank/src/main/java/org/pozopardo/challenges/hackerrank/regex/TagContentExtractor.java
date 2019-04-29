package org.pozopardo.challenges.hackerrank.regex;

import java.util.*;
import java.util.regex.*;

public class TagContentExtractor {

    private static final Pattern PATTERN = Pattern.compile("<(.+)>([^<>]+)</\\1>");
    private static List<String> content;

    public static String extractContent(String line) {
        content = new ArrayList<>();
        findMatches(line);
        return printInnerTagContent(content);
    }

    private static void findMatches(String line) {
        Matcher matcherIn = PATTERN.matcher(line);

        while(matcherIn.find()) {
            content.add(matcherIn.group(2));
        }
    }

    private static String printInnerTagContent(List<String> content) {

        if(content.size() == 0) {
            return "None\n";
        }

        StringBuilder builder = new StringBuilder();
//        for(int i = 0 ; i < content.size()-1 ; i++) {
        for(String part : content) {
            builder.append(part);
            builder.append("\n");
        }
//        builder.append(content.get(content.size()-1));

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        while (testCases > 0) {
            String line = in.nextLine();
            System.out.print(extractContent(line));
            testCases--;
        }

        in.close();
    }
}

