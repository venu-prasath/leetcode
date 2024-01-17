package com.venuprasath.arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.venuprasath.util.Extension.println;

public class LC1207 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3};

        boolean result = uniqueOccurrences(arr);
        println(result);

    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: arr) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        Set<Integer> freqSet = new HashSet<>(freq.values());
        return freq.size() == freqSet.size();
    }
}
