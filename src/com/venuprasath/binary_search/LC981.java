package com.venuprasath.binary_search;

import java.util.HashMap;
import java.util.Map;

public class LC981 {

    public static void main(String[] args) {

        //eg - ["TimeMap", "set", "get", "get", "set", "get", "get"]
        //[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]


    }
}

class TimeMap {
    Map<String, String> map = null;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        String newKey = key + " " + timestamp;
        map.put(newKey, value);
    }

    public String get(String key, int timestamp) {
        String str = key + " " + timestamp;

        if(!map.containsKey(str)) {
            return map.get(str);
        }

        while(!map.containsKey(str) && timestamp > 0) {
            timestamp -= 1;
            str = key + " "  + timestamp;
        }

        return map.getOrDefault(str, "");
    }
}

