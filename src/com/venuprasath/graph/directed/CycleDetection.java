package com.venuprasath.graph.directed;

import java.util.ArrayList;

public class CycleDetection {
    
    ArrayList<ArrayList<Integer>> graph = new ArrayList();
    
    public ArrayList<ArrayList<Integer>> createGraph() {
        //node 0
        ArrayList<Integer> neighbours0 = new ArrayList<>();
        neighbours0.add(1);
        graph.add(neighbours0);

        //node 1
        ArrayList<Integer> neighbours1 = new ArrayList<>();
        neighbours1.add(2);
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
        neighbours5.add(4);
        graph.add(neighbours5);

        //node 6
        ArrayList<Integer> neighbours6 = new ArrayList<>();
        neighbours6.add(7);
        neighbours6.add(1);
        graph.add(neighbours6);

        //node 7
        ArrayList<Integer> neighbours7 = new ArrayList<>();
        neighbours7.add(8);
        graph.add(neighbours7);

        //node 8
        ArrayList<Integer> neighbours8 = new ArrayList<>();
        //neighbours8.add(6);
        graph.add(neighbours8);

        return graph;
    }


    /*
    * 0 - unvisited (default)
    * 1 - exploring
    * 2 - exporation completed
     */
    public boolean graphIsCyclic() {
        int[] visited = new int[graph.size()];
        System.out.println("Graph size: "+graph.size());
        for(int i=0; i<graph.size(); i++) {
            if(visited[i] == 0) {
                if(checkCycle(i, visited)) {
                    System.out.println("Cycle is present");
                    return true;
                }
            }
        }
        System.out.println("No cycles found");
        return false;
    }

    private boolean checkCycle(int i, int[] visited) {
        visited[i] = 1;
        System.out.println("Exploring node: "+i);
        System.out.println("#neighbors: "+ graph.get(i).size());
        for(Integer neighbor: graph.get(i)) {
            if(visited[neighbor] == 0) {
                if(checkCycle(neighbor, visited)) return true;
            } else if(visited[i] == 1){
                return true;
            }
            System.out.println("Backtracking to node "+i);
        }
        visited[i] = 2;
        return false;
    }
}
