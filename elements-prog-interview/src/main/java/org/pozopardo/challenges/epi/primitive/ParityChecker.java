package org.pozopardo.challenges.epi.primitive;

import java.util.HashMap;
import java.util.Map;

/* 5.1 COMPUTE PARITY
 * The parity of a binary word is 1 if the number of 1s in the word is odd;
 * otherwise, it is 0. For example, the parity of 1011 is 1, and the parity of
 * 10001000 is 0. Parity checks are used to detect single bit errors in data
 * storage and communication. It is fairly straightforward to write code that
 * computes the parity of a single 64-bit word.
 *
 * Problem 5.1 How would you compute the parity of a very large number of 64-bit
 * words?
 */

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
