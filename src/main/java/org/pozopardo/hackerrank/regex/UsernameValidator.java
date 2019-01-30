package org.pozopardo.hackerrank.regex;

import java.util.Scanner;

public class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "\\b[a-zA-Z]\\w{7,28}$";

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

