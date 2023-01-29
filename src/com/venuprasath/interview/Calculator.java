package com.venuprasath.interview;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    List<Integer> operators = new ArrayList();

    public static void main(String[] args) {

        Calculator calc = new Calculator();

    }

    public int Add(int operator1, int operator2) {
        return operator1 + operator2;
    }

    public int Subtract(int operator1, int operator2) {
        return operator1 - operator2;
    }

    public int Multiply(int operator1, int operator2) {
        return operator1 * operator2;
    }

    public int Divide(int operator1, int operator2) {
        return operator1/operator2;
    }


}
