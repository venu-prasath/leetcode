package com.venuprasath.priorityQueue;

import java.util.*;

import static com.venuprasath.util.Extension.println;

public class LC621 {

    public static void main(String[] args) {
        char[] tasks = new char[] {'A', 'A', 'A', 'B', 'B', 'B'};

        LC621 solution = new LC621();
        int answer = solution.leastInterval2(tasks, 2);
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

    private int leastInterval2(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25];
        int idleTime = (maxFreq - 1) * n;

        for (int i = 24; i >= 0 && idleTime > 0; i--) {
            idleTime -= Math.min(maxFreq - 1, freq[i]);
        }

        idleTime = Math.max(0, idleTime);

        return tasks.length + idleTime;
    }
}
