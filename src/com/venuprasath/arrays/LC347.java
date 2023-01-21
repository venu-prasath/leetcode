package com.venuprasath.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.venuprasath.util.Extension.print;

public class LC347 {

    public static void main(String[] args) {

        //eg - [1,1,1,2,2,3], [1, 2]
        int[] nums = { 1, 1, 1, 1, 2, 2, 2, 3 };
        LC347 solution = new LC347();
        int[] values = solution.topKFrequent(nums, 2);

        for(Integer num: values) {
            print(num.toString());
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> res = new ArrayList<>();
        int[] result = new int[k];
        int counter = 0;

        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
                result[counter] = bucket[pos].get(0);
                counter++;
            }
        }
        return result;
    }
}
