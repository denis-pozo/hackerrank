package org.pozopardo.hackerrank.regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class MyRegexSolution {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {

    String pattern;

    MyRegex() {
        pattern = "^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$";
    }


}

