package org.pozopardo.challenges.hackerrranck.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {

        String regex = "\\b([a-z]+)\\b(?:\\s+\\1\\b)+";
        /*
         * \b match word boundaries
         * ([a-z]+) match and capture a word with 1 or more characters
         * (?: non-capturing group starting here
         * \s+ match one or more whitespace characters
         * \1 back reference to the first (captured) group, it means repetition
         * )+ one or more repetitions
         */

        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(0), m.group(1));
                /*
                 * m.group(0) is the string matched, also m.group()
                 * m.group(n) is the nth string captured using ()
                 */
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
    }
}

