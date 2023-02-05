package com.venuprasath.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.venuprasath.util.Extension.print;
import static java.sql.DriverManager.println;

public class Accord {

    public static void main(String[] args) {

        //eg input -

        Accord solution = new Accord();
        Integer res = solution.limiter(3);
        print(res);

        String res2 = solution.readFirstLine("asdbv");
    }

     Integer limiter(Integer n) {
        if(n == 6) {
            return 3;
        } else {
            return 3* limiter(n+1);
        }
     }

    public static String readFirstLine(String path) {
        BufferedReader file = null;
        String buffer = null;
        try {
            file = new BufferedReader(new FileReader(path));
            buffer = file.readLine();

        } catch (IOException e) {
            println("asd");
        } finally {
            if(file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    println("asdfasdf");
                }
            }
        }
        return buffer;
    }




}
