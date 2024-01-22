package com.venuprasath.rejection_sampling;

import java.util.Random;

import static com.venuprasath.util.Extension.println;

public class LC470 {

    public static void main(String[] args) {
        println(rand10());
    }

    public static int rand10() {
        int row=0, col=0, i=100;
        while(i > 40) {
            row = rand7();
            col = rand7();
            i = (row-1)*7 + col;
        }
        return 1+(i-1)%10;
    }

    public static int rand7() {
        //Generates number in the range [1, 7] uniformly
        Random rnd = new Random();
        return rnd.nextInt(1, 7);
    }

}
