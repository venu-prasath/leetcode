package com.venuprasath.binary_search;

import static com.venuprasath.util.Extension.print;

public class LC4 {

    public static void main(String[] args) {
        //eg - nums1 = [1,3], nums2 = [2]
        int[] n1 = new int[] {1, 3};
        int[] n2 = new int[] { 2 };
        LC4 solution = new LC4();
        double result = solution.findMedianSortedArrays(n1, n2);
        print(result);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int s1 = nums1.length;
        int s2 = nums2.length;
        int[] combined = new int[s1+s2];
        int i = 0, j = 0, k = 0;

        while(i < s1 && j < s2) {
            if(nums1[i] < nums2[j]) {
                combined[k] = nums1[i];
                i++;
            } else {
                combined[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < s1) {
            combined[k] = nums1[i];
            i++;
            k++;
        }

        while(j < s2) {
            combined[k] = nums2[j];
            j++;
            k++;
        }

        int mid = combined.length / 2;
        if(combined.length % 2 != 0) {
            return combined[mid];
        } else {
            return (combined[mid] + combined[mid - 1])/2.0;
        }
    }
}
