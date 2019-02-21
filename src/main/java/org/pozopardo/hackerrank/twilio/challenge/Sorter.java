package org.pozopardo.hackerrank.twilio.challenge;

import java.io.IOException;
import java.util.*;

public class Sorter {

    /*
     * Complete the 'customSort' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static void customSort(List<Integer> arr) {
        Map<Integer, Integer> frequenciesOfNumbers = getNumbersFrequencies(arr);
        Map<Integer, ArrayList<Integer>> arraysOfFrequencies =
                                            getReverseMap(frequenciesOfNumbers);

        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> arrayOfFrequencyEntry :
                                                arraysOfFrequencies.entrySet()){
            result.addAll(getSubArray(arrayOfFrequencyEntry));
        }

        ListIterator iterator = arr.listIterator();
        for(Integer i : result) {
            iterator.next();
            iterator.set(i);
        }
    }

    private static List<Integer> getSubArray(Map.Entry<Integer,ArrayList<Integer>> entry) {
        List<Integer> subArray = new ArrayList<>();
        for(Integer i : entry.getValue()) {
            for(int j = 0 ; j < entry.getKey() ; j++) {
                subArray.add(i);
            }
        }

        return subArray;
    }


    private static Map<Integer,Integer> getNumbersFrequencies(List<Integer> arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int frequency = 1;

        for(Integer value : arr) {
            if(counts.containsKey(value)){
                frequency = counts.get(value) + 1;
            }
            counts.put(value, frequency);
            frequency = 1;
        }
        return counts;
    }

    private static Map<Integer, ArrayList<Integer>> getReverseMap(Map<Integer, Integer> map){
        Map<Integer, ArrayList<Integer>> reverseMap = new HashMap<>();

        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (!reverseMap.containsKey(entry.getValue())) {
                reverseMap.put(entry.getValue(), new ArrayList<>());
            }
            ArrayList<Integer> keys = reverseMap.get(entry.getValue());
            keys.add(entry.getKey());
            reverseMap.put(entry.getValue(), keys);
        }

        return reverseMap;
    }

    public static void main(String[] args) throws IOException {
        List<Integer> inputArray = Arrays.asList(new Integer[]{1,2,3,8,7,0,1,2,3,9,8,5,7,0,1,2,3,4,8,7,5,0,1,2,9,3,5,8,0,1,9,8,3,2,7,1,3,4});
        customSort(inputArray);
        System.out.println(getReverseMap(getNumbersFrequencies(inputArray)));
        System.out.println(inputArray);
    }
}
