package org.pozopardo.challenges.hackerrranck.basics;

import java.util.Scanner;

public class EndOfFile {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        while(scanner.hasNext()) {
            System.out.println(i++ + " " + scanner.nextLine());
        }
    }


}
