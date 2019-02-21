package org.pozopardo.hackerrank.advanced;

import java.io.*;
import java.util.*;


interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isOdd() {
        return (t) -> (t % 2 != 0);
    }

    public PerformOperation isPrime() {
        return (t) -> (prime(t));
    }

    private boolean prime(int number) {
        for(int i = 2 ; i <= number/2 ; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public PerformOperation isPalindrome() {
        return (t) -> (palindrome(String.valueOf(t)));
    }

    private boolean palindrome(String number) {
        String reverse = "";
        for(int i = number.length()-1 ; i >= 0 ;  i--) {
            reverse = reverse + number.charAt(i);
        }

        if(number.equals(reverse)) return true;
        else return false;
    }
}
public class MathOperation {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}


