package com.venuprasath.stack;

import java.util.Arrays;

import static com.venuprasath.util.Extension.print;

public class LC853 {

    public static void main(String[] args) {
        //eg - target = 12, pos = [10,8,0,5,3], speed = [2,4,1,1,3]
        int target = 12;
        int[] pos = new int[] { 10, 8, 0, 5, 3 };
        int[] speed = new int[] { 2, 4, 1, 1, 3 };
        LC853 solution = new LC853();
        int result = solution.carFleet(target, pos, speed);
        print(result);
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int result = 0;
        int size = position.length;
        double[][] cars = new double[size][2];

        for(int i = 0; i < size; i++) {
            cars[i] = new double[] { position[i], (double) (target - position[i])/speed[i] };
        }

        Arrays.sort( cars, (a, b) -> Double.compare(a[0], b[0]) );
        double cur = 0;

        for(int i = size-1; i>=0; i--) {
            if(cars[i][1] > cur) {
                cur = cars[i][1];
                result++;
            }
        }
        return result;
    }
}
