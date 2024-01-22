package com.venuprasath.rejection_sampling;

import static com.venuprasath.util.Extension.println;

public class LC478 {

    public static void main(String[] args) {
        double[] ans = randPoint(5.0f, 2.3f, 3.3f);
        println("x: "+ans[0] + ", y: "+ans[1]);
    }

    public static double[] randPoint(double radius, double x_c, double y_c) {
        double x0 = x_c - radius;
        double y0 = y_c - radius;

        while(true) {
            double xg = x0 + Math.random() * radius * 2;
            double yg = y0 + Math.random() * radius * 2;
            if(Math.sqrt(Math.pow(xg-x_c, 2) + Math.pow(yg-y_c, 2)) <= radius) {
                return new double[]{xg, yg};
            }
        }
    }
}
