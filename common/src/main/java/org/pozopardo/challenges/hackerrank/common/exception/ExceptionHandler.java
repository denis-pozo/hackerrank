package org.pozopardo.challenges.hackerrank.common.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandler {

    public static void main (String [] args) {
        Scanner in = new Scanner(System.in);
        try {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(x/y);
        } catch (InputMismatchException ime) {
            System.out.println(ime.getClass().getName());
        } catch (ArithmeticException ae) {
            System.out.println(ae.getClass().getName() + ": / by zero");
        }
        in.close();
    }
}
