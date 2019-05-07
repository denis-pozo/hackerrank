package org.pozopardo.challenges.hackerrank.common.data.structure;

import java.util.Scanner;
import java.util.Stack;

public class BalancedStringChecker {

    public static boolean isBalanced(String string) {

        if (string.length() == 1)
            return false;

        Stack<Character> charStack = new Stack<>();
        int index = 0;

        while (index < string.length()) {
            Character c = string.charAt(index++);

            if (isOpening(c)) {
                charStack.push(c);
            } else if (isClosing(c) && !charStack.isEmpty()) {
                Character fromStack = charStack.pop();
                if(!opposite(c, fromStack)){
                    return false;
                }
            } else {
                return false;
            }
        }

        if(charStack.isEmpty()) {
            return true;
        }
        return false;
    }

    private static boolean opposite(Character closing, Character opening) {
        if(opening == '{' && closing == '}')
            return true;
        if(opening == '[' && closing == ']')
            return true;
        if(opening == '(' && closing == ')')
            return true;
        return false;
    }

    private static boolean isOpening(Character c) {
        if(c == '{' || c == '[' || c == '(')
            return true;
        return false;
    }

    private static boolean isClosing(Character c) {
        if(c == '}' || c == ']' || c == ')')
            return true;
        return false;
    }

    public static void main(String [] args) {

        {
            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                String input=sc.next();
                if(isBalanced(input))
                    System.out.println("true");
                else
                    System.out.println("false");
            }

        }
    }
}
