package org.pozopardo.hackerrank.basics;

import java.util.Scanner;

public class StaticInit {

    static {
        Scanner scanner = new Scanner(System.in);
        int inputB = scanner.nextInt();
        int inputH = scanner.nextInt();
        scanner.close();

        if (inputH <= 0 || inputB <= 0 ) {
           throw new RuntimeException("Breath and Height must be possitive");
        }
        B = inputB;
        H = inputH;
    }

    private static int B;
    private static int H;

    public static void main(String[] args){
        int area=B*H;
        System.out.print(area);

    }//end of main

}//end of class

