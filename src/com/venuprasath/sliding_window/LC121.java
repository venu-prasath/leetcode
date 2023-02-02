package com.venuprasath.sliding_window;

import static com.venuprasath.util.Extension.print;

public class LC121 {

    public static void main(String[] args) {
        //eg - [7,1,5,3,6,4]

        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        LC121 solution = new LC121();
        int result = solution.maxProfit(prices);
        print(result);
    }

    public int maxProfit(int[] prices)  {
        if(prices.length == 0) return 0;
        int maxProfit = 0;
        int minPrice = prices[0];

        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxProfit;
    }
}
