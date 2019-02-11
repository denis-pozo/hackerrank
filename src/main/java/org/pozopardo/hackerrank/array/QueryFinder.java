package org.pozopardo.hackerrank.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QueryFinder {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int nLines = scanner.nextInt();

        List<Integer>[] lines = new List[nLines];
        for(int i = 0 ; i < nLines ; i++) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] linesArray = scanner.nextLine().split(" ");
            List<Integer> line = toIntegerList(linesArray);
            lines[i] = line;
        }

        int nQueries = scanner.nextInt();
        for(int i = 0 ; i < nQueries ; i++) {
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] queriesArray = scanner.nextLine().split(" ");
            int line = Integer.valueOf(queriesArray[0]);
            int element = Integer.valueOf(queriesArray[1]);
            printQueryResult(lines, line, element);
        }

        scanner.close();

    }

    private static void printQueryResult(List<Integer>[] lines, int line, int element) {

        try {
            System.out.println(lines[line-1].get(element));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR!");
        }
    }

    private static List<Integer> toIntegerList(String[] linesArray) {
        int[] ints = Stream.of(linesArray).mapToInt(Integer::parseInt).toArray();
        List<Integer> line = Arrays.stream(ints).boxed().collect(Collectors.toList());
        return line;
    }
}
