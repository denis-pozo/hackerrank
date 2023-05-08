package org.pozopardo.challenges.hackerrank.intpreps.queen;

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class QueensGame {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int numberOfTests = scanner.nextInt();

        for(int i = 0 ; i < numberOfTests ; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.nextLine();

            List<String> board = new ArrayList<>();
            for(int j = 0 ; j < n ; j++) {
                String line = scanner.nextLine();
                board.add(line);
            }
            int result = QueensGame.queens(board);
            writer.write(String.valueOf(result));
            writer.newLine();
            System.out.println(writer);

        }
        scanner.close();
        writer.close();
    }

    public static int queens(List<String> board) {
        if(board.size() == 0) {
            return 0;
        }

        final boolean [][] cellIsBlocked = extractBlockedCells(board);
        int result = countUnblockedCells(cellIsBlocked);
        if (board.size() == 1) {
            return result;
        }

        // For each number of queens from 1 to min(nFiles, nColls) compute all the possible
        // arrangements
        int nRows = cellIsBlocked.length;
        int nColls = cellIsBlocked[0].length;
        int maxQueens = min(nRows, nColls);
        for (int n = 2 ; n <= maxQueens ; n++) {
            result =+ nQueens(n, cellIsBlocked);
        }
        return result;
    }

    public static int nQueens(int n, boolean[][] cellIsBlocked) {
        int numberOfSolutions = 0;
        int nRows = cellIsBlocked.length;
        int nCols = cellIsBlocked[0].length;

        // Steps:
        // 1. Our choice
        // 2. Is valid?
        // 3. Our goal
        List<Integer> solutionArray = new ArrayList<>();
        for(int col = 0; col < nCols; col++) {
            if(placeQueen(0, col, n, solutionArray, cellIsBlocked)) {
                numberOfSolutions++;
            }
        }
        return numberOfSolutions;
    }

    private static boolean placeQueen(int row, int col, int n, List<Integer> solutionArray,
                                      boolean[][] cellIsBlocked) {
        int nRows = cellIsBlocked.length;
        int nCols = cellIsBlocked[0].length;

        if(row == nRows) {
            return false;
        }

        solutionArray.add(col);
        if(isNotValid(solutionArray, cellIsBlocked)) {
            solutionArray.remove(solutionArray.size() - 1);
            return false;
        }

        if(solutionArray.size() == n) {
            return true;
        }

        row++;
        for(int colIndex = 0; colIndex < nCols ; colIndex++) {
            if(colIndex != col) {
                return placeQueen(row, colIndex, n, solutionArray,cellIsBlocked);
            }
        }

        return false;
    }

    private static boolean isNotValid(List<Integer> solutionArray, boolean[][] cellIsBlocked) {

        if(cellIsBlocked[solutionArray.size()][solutionArray.get(solutionArray.size()-1)]) {
            return true;
        }

        Set<Integer> solutionSet = new HashSet<>();
        solutionSet.addAll(solutionArray);

        if(solutionArray.size() != solutionSet.size()) {
            return true;
        }

        int currentQueenRow = solutionArray.size()-1;
        int currentQueenCol = solutionArray.get(currentQueenRow);

        for(int i = 0; i < solutionArray.size()-1 ; i++) {
            if(abs(i-solutionArray.get(i)) == abs(currentQueenRow-currentQueenCol) ) {
                return true;
            }
        }

        return false;
    }

    public static int countUnblockedCells(boolean[][] cellIsBlocked) {
        int counter = 0;

        for(int i = 0 ; i < cellIsBlocked.length ; i++) {
            for(int j = 0 ; j < cellIsBlocked[i].length ; j++) {
                if(!cellIsBlocked[i][j]) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static boolean[][] extractBlockedCells(List<String> board) {
        int nRows = board.size();
        int nCols = board.get(0).trim().length();
        boolean [][] cellIsBlocked = new boolean [nRows][nCols];

        for(int row = 0 ; row < nRows ; row++) {
            char[] splitLine = board.get(row).toCharArray();
            for(int col = 0 ; col < nCols ; col++)
                cellIsBlocked[row][col] = !Objects.equals(splitLine[col], '.');
            }
        return cellIsBlocked;
    }
}
