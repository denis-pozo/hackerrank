package org.pozopardo.challenges.hackerrank.intpreps.tomtom;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shuffler {
    public int shuffle(int A) {
        LinkedList<Integer> number = new LinkedList<>();

        while(A > 0) {
            number.add(A % 10);
            A = A / 10;
        }

        int result = 0;
        boolean first = false;
        double i = Math.pow(10, number.size()-1);
        while(number.size() > 0) {
            if (first) {
                result += i * number.removeFirst();
                first = false;
            } else {
                result += i * number.removeLast();
                first = true;
            }
            i /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        Shuffler shu = new Shuffler();
        System.out.println(shu.shuffle(123456));
    }
}
