package org.pozopardo.challengeepi.primitive;

import java.util.HashMap;
import java.util.Map;

public class ParityChecker {

    private static Map<Long,Boolean> cache = new HashMap<>(65536);
    static {
        for(long i = 0 ; i <= 65535 ; i++) {
            cache.put(i, isParityOne(i));
        }
    }

    public static boolean isParityOneImproved (long number) {
        int count = 0;
        for(int i = 0 ; i < 4 ; i++) {
            long block = number >> (16*i) & 0xFFFF;
            if(cache.get(block)) count = count ^ 1;
        }
        return count == 1;
    }

    public static boolean isParityOne (long number) {
        long count = 0;
        long temp = number;
        while(temp > 0) {
            count = count + temp & 1;
            temp >>=1;
        }

//        System.out.format("Is %d %016d parity one?",number, new BigInteger(Long.toBinaryString(number)));
        if(count == 1) {
//            System.out.println(" Yes");
            return true;
        } else {
//            System.out.println(" No");
            return false;
        }
    }
}
