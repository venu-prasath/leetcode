package com.venuprasath.math.basic;

import static com.venuprasath.util.Extension.println;

public class ArmstrongNumber {

    public static void main(String[] args) {
        int n = 371;
        boolean res = isArmstrong(n);
        println(res);
    }

    public static boolean isArmstrong(int n) {
        int duplicate = n;
        int sum = 0;
        while(n > 0) {
            int last = n % 10;
            sum += last * last * last;
            n = n / 10;
        }
        return sum == duplicate;
    }


}
