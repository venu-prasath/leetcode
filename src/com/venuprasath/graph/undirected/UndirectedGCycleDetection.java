package com.venuprasath.graph.undirected;

import java.util.ArrayList;

public class UndirectedGCycleDetection {

    ArrayList<ArrayList<Integer>> graph = new ArrayList();

    public ArrayList<ArrayList<Integer>> createGraph() {
        //node 0
        ArrayList<Integer> neighbours0 = new ArrayList<>();
        neighbours0.add(1);
        graph.add(neighbours0);

        //node 1
        ArrayList<Integer> neighbours1 = new ArrayList<>();
        neighbours1.add(2);
        neighbours1.add(6);
        graph.add(neighbours1);

        //node 2
        ArrayList<Integer> neighbours2 = new ArrayList<>();
        neighbours2.add(3);
        neighbours2.add(5);
        graph.add(neighbours2);

        //node 3
        ArrayList<Integer> neighbours3 = new ArrayList<>();
        neighbours3.add(4);
        graph.add(neighbours3);

        //node 4
        ArrayList<Integer> neighbours4 = new ArrayList<>();
        graph.add(neighbours4);

        //node 5
        ArrayList<Integer> neighbours5 = new ArrayList<>();
        //neighbours5.add(4);
        graph.add(neighbours5);

        //node 6
        ArrayList<Integer> neighbours6 = new ArrayList<>();
        neighbours6.add(7);
        neighbours6.add(1);
        neighbours6.add(8);
        graph.add(neighbours6);

        //node 7
        ArrayList<Integer> neighbours7 = new ArrayList<>();
        neighbours7.add(8);
        graph.add(neighbours7);

        //node 8
        ArrayList<Integer> neighbours8 = new ArrayList<>();
        neighbours8.add(7);
        neighbours8.add(6);
        graph.add(neighbours8);

        return graph;
    }


    /*
     * 0 - unvisited (default)
     * 1 - visited
     */
    public boolean isGraphCyclic(int current, int parent) {
        int[] visited = new int[graph.size()];
        System.out.println("Graph size: "+graph.size());
        if(visited[current] == 0) {
            visited[current] = 1;
            for(int i=current; i<graph.get(current).size(); i++) {
                if(visited[i] == 1 && i == parent) {
                    /* do nothing */
                } else if(visited[i] == 1 && i != parent && parent != -1) {
                    System.out.println("i = " + i + ", " + current + ", " + parent);
                    return true;
                } else {
                    isGraphCyclic(i, current);
                }
            }
        }
        System.out.println("current: " + current + ", " + parent);
        return false;
    }
}
