package com.venuprasath.arrays;

import java.util.ArrayList;
import java.util.List;

import static com.venuprasath.util.Extension.print;

public class LC659 {

    public static void main(String[] args) {

        //eg - ["lint","code","love","you"]
        List<String> stringList = new ArrayList<>();
        stringList.add("lint");
        stringList.add("code");
        stringList.add("love");
        stringList.add("you");

        LC659 solution = new LC659();
        String encodedString = solution.encode(stringList);
        print(encodedString);

        List<String> answer = solution.decode(encodedString);
        for(String s: answer) {
            print(s);
        }
    }

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str + "##");
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (s.charAt(j) != '#') j++;
            res.add(s.substring(i, j));
            i = j+2;
        }
        return res;
    }
}
