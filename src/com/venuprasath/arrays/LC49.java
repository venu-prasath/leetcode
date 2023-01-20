package com.venuprasath.arrays;

import java.util.*;

public class LC49 {

    public static void main(String[] args) {
        String[] s1 = {"eat","tea","tan","ate","nat","bat"};
        String[] s2 = {""};
        String[] s3 = { "a" };

        LC49 solution = new LC49();
        solution.groupAnagrams(s1);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();
        result.add(new ArrayList<>());
        if(strs.length < 1) return result;
        if(strs.length == 1) {
            result.clear();
            String value = strs[0];
            ArrayList<String> innerList = new ArrayList<>();
            innerList.add(value);
            result.add(innerList);
            return result;
        }

        List<List<String>>s=new ArrayList<>();
        Map<String,List<String>> map=new LinkedHashMap<>();

        for(String e:strs){
            char ch[]=e.toCharArray();
            Arrays.sort(ch);
            String str=new String(ch);

            if(!map.containsKey(str)){
                map.put(str,new ArrayList<>());
            }
            map.get(str).add(e);
        }
        s.addAll(map.values());
        return s;
    }
}
