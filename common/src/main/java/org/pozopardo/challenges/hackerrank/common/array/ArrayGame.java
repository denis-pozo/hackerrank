package org.pozopardo.challenges.hackerrank.common.array;

import java.util.Scanner;

public class ArrayGame {

    public static boolean canWin(int leap, int[] game) {
        boolean gameOver = false;
        boolean win = false;
        int returnedIndex = 0;
        int count = 0;

        while(!gameOver && !win) {
            returnedIndex = play(leap, game);
            count++;
            if(returnedIndex < game.length) {
                if(returnedIndex == 0){
                    gameOver = true;
                } else {
                    game[returnedIndex] = 1;
                }
            } else {
                win = true;
            }
        }

        System.out.println("# of Plays: " + count);
        return win;
    }

    public static int play(int leap, int[] game) {
        int currentIndex;
        int nextIndex = 0;

        while(nextIndex < game.length) {
            currentIndex = indexBeforeNextOne(game, nextIndex);
            nextIndex = nextMove(game, leap, currentIndex);

            if(currentIndex >= nextIndex)
                return nextIndex;
        }

        return nextIndex;
    }

    private static int nextMove(int[] game, int leap, int currentIndex) {
        if(currentIndex == game.length-1){
            return game.length;
        }

        int jumps = leap;
        while(jumps-- > 1) {
            if(canJump(game, currentIndex + leap)){
                currentIndex = currentIndex + leap;
                return currentIndex;
            } else if (canWalkBackward(game, currentIndex)){
                currentIndex--;
            } else {
                return currentIndex;
            }
        }

        return currentIndex;
    }

    private static boolean canWalkBackward(int[] game, int currentIndex) {
        if(currentIndex == 0) return false;
        if(game[currentIndex-1] == 1) return false; else return true;
    }

    private static boolean canJump(int[] game, int jump) {
        if(jump >= game.length) return true;
        if(game[jump] == 0) return true; else return false;
    }

    private static int indexBeforeNextOne(int[] game, int currentIndex) {

        for(int i = currentIndex ; i < game.length ; i++) {
            if(game[i] == 1) return i-1;
        }

        return game.length-1;
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
            System.out.println((canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
