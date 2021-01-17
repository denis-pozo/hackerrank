package org.pozopardo.challenges.hackerrank.intpreps.datastructures;

import java.io.*;
import java.util.*;

public class ContactFinderWithHashMap {

    /*
     * Complete the contacts function below.
     */
    static int[] contacts(String[][] queries) {
        Map<String, Integer> contactsLookup = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        /*
         * Write your code here.
         */
        for(int i = 0; i < queries.length ; i++) {
            String command = queries[i][0];
            String partial = queries[i][1];
            if(command.equalsIgnoreCase("add")) {
                add(contactsLookup, partial);
            } else {
                res.add(find(contactsLookup, partial));
            }
        }

        int [] result = new int [res.size()];
        for(int i = 0; i < res.size() ; i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void add(Map<String, Integer> contactsLookup, String contact) {
        for(int i = 1; i <= contact.length() ; i++) {
            String sub = contact.substring(0,i);
            if(contactsLookup.containsKey(sub)) {
                contactsLookup.put(sub, contactsLookup.get(sub)+1);
            } else {
                contactsLookup.put(sub, 1);
            }
        }
    }

    public static int find(Map<String, Integer> contactsLookup, String partial) {
        if(contactsLookup.containsKey(partial)) {
            return contactsLookup.get(partial);
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int queriesRows = Integer.parseInt(scanner.nextLine().trim());

        String[][] queries = new String[queriesRows][2];

        for (int queriesRowItr = 0; queriesRowItr < queriesRows; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");

            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                String queriesItem = queriesRowItems[queriesColumnItr];
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }

        int[] result = contacts(queries);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }

}
