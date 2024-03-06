package com.venuprasath.fast_slow_ptrs;

public class HappyNumber {

    public static void main(String[] args) {
        int number = 19;
        if (isHappy(number)) {
            System.out.println(number + " is a Happy Number");
        } else {
            System.out.println(number + " is not a Happy Number");
        }
    }

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while(slow != fast);
        return slow == 1;
    }

    public static int sumOfSquares(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
