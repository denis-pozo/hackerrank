package org.pozopardo.hackerrank.data.structure;

import java.util.*;

public class UniqueIntegersDeque {

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(maxNumberOfUnique(in));
        in.close();
    }

    public static int maxNumberOfUnique(Scanner in) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();
        int maxUniqueNumbers = 0;
        Set<Integer> set = new HashSet<>(m);

        for(int i = 0; i < n ; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            set.add(num);
            if(deque.size() == m) {
                if (maxUniqueNumbers < set.size())
                    maxUniqueNumbers = set.size();
                int polled = deque.pollFirst();
                if(!deque.contains(polled))
                    set.remove(polled);
            }
        }
        return maxUniqueNumbers;
    }
}
