package org.pozopardo.hackerrank.basics;

import java.io.*;
import java.text.*;
import java.util.*;

public class DateAndTime {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int month =  in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        in.close();

        String res = Result.findDay(month, day, year);
        System.out.println(res);
    }
}


class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar cal = new Calendar.Builder().setDate(year, month-1, day).build();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
        String dayOfWeek = dateFormat.format(cal.getTime());
        return String.valueOf(dayOfWeek).toUpperCase();
    }

}


