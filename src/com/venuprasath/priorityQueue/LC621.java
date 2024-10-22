package com.venuprasath.priorityQueue;

import java.util.*;

import static com.venuprasath.util.Extension.println;

public class LC621 {

    public static void main(String[] args) {
        char[] tasks = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};

        LC621 solution = new LC621();
        int answer = solution.leastInterval(tasks, 2);
        println("Output: " + answer);
    }

    private int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        for(char t: tasks) map.put(t, map.getOrDefault(t, 0)+1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(map.size(), (a,b) -> b-a);
        pq.addAll(map.values());

        int time = 0;
        Queue<int[]> coolDownQueue = new LinkedList();
        while(!pq.isEmpty() || !coolDownQueue.isEmpty()) {
            time++;

            if(!pq.isEmpty()) {
                int currFreq = pq.poll();
                currFreq--;
                if(currFreq > 0) {
                    coolDownQueue.add(new int[] { currFreq, time + n });
                }
            }

            if(!coolDownQueue.isEmpty() && coolDownQueue.peek()[1] == time) {
                pq.add(coolDownQueue.poll()[0]);
            }

        }
        return time;
    }
}
