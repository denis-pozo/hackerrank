package org.pozopardo.hackerrank.data.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperator {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nElements = scanner.nextInt();
        List<Integer> list = new ArrayList<>(nElements);

        while(nElements-- > 0) {
            list.add(scanner.nextInt());
        }

        int q = scanner.nextInt();
        while(q-- > 0) {
            String query = scanner.next("Insert|Delete");
            if(query.equalsIgnoreCase("Insert")){
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            } else {
                int index = scanner.nextInt();
                list.remove(index);
            }
        }

        print(list);
        scanner.close();
    }

    private static void print(List<Integer> list) {
        StringBuilder str = new StringBuilder();
        for(Integer i : list) {
            str.append(i);
            str.append(" ");
        }
        str.append("\n");
        System.out.println(str.toString());
    }
}
