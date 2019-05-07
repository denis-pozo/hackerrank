package org.pozopardo.challenges.hackerrank.common.basics;

import java.util.*;
import java.text.*;

public class CurrencyFormater {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        NumberFormat nfUsa = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat nfChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat nfFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);

        NumberFormat nfIndia = NumberFormat.getCurrencyInstance();
        DecimalFormatSymbols symbol = new DecimalFormatSymbols(new Locale("en", "INDIA"));
        symbol.setCurrencySymbol("Rs.");
        ((DecimalFormat) nfIndia).setDecimalFormatSymbols(symbol);

        System.out.println("US: " + nfUsa.format(payment));
        System.out.println("India: " + nfIndia.format(payment));
        System.out.println("China: " + nfChina.format(payment));
        System.out.println("France: " + nfFrance.format(payment));
    }
}
