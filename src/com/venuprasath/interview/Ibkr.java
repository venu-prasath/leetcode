package com.venuprasath.interview;

import static com.venuprasath.util.Extension.print;

public class Ibkr {

    //input1 - [0, 1000]
    //input2 = [0.1, 0.5]
    //input3 = 2000

    public static void main(String[] arsgs) {
        double[] input1 = { 0.0, 1000.0 };
        double[] input2 = { 0.1, 0.5 };
        double input3 = 2000.0;

        Ibkr sol = new Ibkr();
        double result = sol.tax_calculator(input1, input2, input3);
        print(result);
    }

    private double tax_calculator(double[] input1, double[] input2, double input3) {
        double tax = 0;
        double income = input3;
        if(input1.length < 2) return tax;
        int j = 0;
        for(int i=1; i<input1.length; i+=2, j++) {
            if(input3 > input1[i]) {
                double x = (input1[i] - input1[i-1]) * input2[i-1];
                tax += x;
                income -= (input1[i] - input1[i-1]);
            } else {
                tax += ((input1[i] - input1[i-2]) * input2[j]);
                income -= (input1[i] - input1[i-2]);
            }
        }
        if(income > 0) {
            tax += (income) * input2[j];
        }

        return tax;
    }
    /*private double tax_calculator(double[] input1, double[] input2, double input3) {
        int i=1;
        int j=i-1;
        double income = input3;
        double tax = 0;
        if(input1.length < 2) return 0.0;

        while(i < input1.length) {
            if(income < input1[i]) {
                tax += input2[i] * income;
            } else {
                tax += calculateTax(input1[i], input2[j]);
                income -= input1[i];
                i += 2;
            }
        }
        if(income == 0) {
            return tax;
        }
        return tax;
    }*/
}
