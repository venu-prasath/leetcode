package com.venuprasath.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LC77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k == 0) {
            res.add(new ArrayList<>());
            return res;
        }
        combine(1, n, k, new ArrayList<>(), res);
        return res;
    }

    private void combine(int start, int n, int k, List<Integer> curr, List<List<Integer>> res) {
        if(curr.size() == k) {
            res.add(new ArrayList(curr));
        }
        for(int i=start; i<=n; i++) {
            curr.add(i);
            combine(i+1, n, k, curr, res);
            curr.remove(curr.size()-1);
        }
    }
}
