package org.pozopardo.hackerrank.array;

import java.util.Scanner;

public class ArrayGame {

    public static boolean canWin(int leap, int[] game) {
       int currentIndex = 0;
       boolean gameOver = false;

       while(currentIndex < game.length && !gameOver) {
           if(canJump(currentIndex + leap, game)){
               currentIndex = currentIndex + leap;
           } else if (canMoveForward(currentIndex, game)){
               currentIndex++;
           } else {
               gameOver = true;
           }
       }
        return !gameOver;
    }

    private static boolean canJump(int newIndex, int[] game) {
        if(newIndex >= game.length ) return true;
        if(game[newIndex] == 0) return true;
        return false;
    }

    static boolean canMoveForward(int currentIndex, int[] game){
        if(currentIndex == game.length-1) return true;
        if(game[currentIndex+1] == 0) return true;
        return false;
    }

    static boolean canMoveBackward(int currentIndex, int[] game){
        if(currentIndex == 0) return false;
        if(game[currentIndex-1] == 0) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
