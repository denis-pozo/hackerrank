package org.pozopardo.hackerrank.number;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BigDecimalSorter {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

        sortBigDecimal(s);

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

    static void sortBigDecimal(String[] decimalArray) {
        List<String> decimalList = new ArrayList<>();
        for(String decimal : decimalArray) {
            if(decimal != null) {
                decimalList.add(decimal);
            }
        }

        Collections.sort(decimalList, (s1, s2) -> {
            BigDecimal bigDecimal1 = new BigDecimal(s1);
            BigDecimal bigDecimal2 = new BigDecimal(s2);
            if(bigDecimal1.doubleValue() > bigDecimal2.doubleValue()) {
                return -1;
            } else {
                return 1;
            }
        });

//        Prior to Java 8
//        Collections.sort(decimalList, new Comparator<BigDecimal>() {
//            @Override
//            public int compare(String s1, String s2) {
//                BigDecimal bigDecimal1 = new BigDecimal(s1);
//                BigDecimal bigDecimal2 = new BigDecimal(s2);
//                if(bigDecimal1.doubleValue() > bigDecimal2.doubleValue()) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });

        for(int i = 0 ; i < decimalList.size() ; i++) {
            decimalArray[i] = decimalList.get(i);
        }
    }
}
