package com.venuprasath.graph.bellman;


import java.util.ArrayList;

/*
* Detect negative cycles
* Will not work with negative cycles
* Works for DG for both positive edges
* For UG, UG needs to be converted to DG
 */
class Node {
    private int u;
    private int v;
    private int weight;

    Node() {}

    Node(int _u, int _v, int _wt) {
        u = _u;
        v = _v;
        weight = _wt;
    }

    int getU() { return u; }
    int getV() { return v; }
    int getWeight() { return weight; }
}

public class BellmanFord {

    void run(ArrayList<Node> adj, int n, int src) {
        int dist[] = new int[n];

        for(int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        int flag = 0;

        for(int i=1; i<n-1; i++) {
            for(Node node: adj) {
                if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                    dist[node.getV()] = dist[node.getU()] + node.getWeight();
                }
            }

        }

        for(Node node: adj) {
            if(dist[node.getU()] + node.getWeight() < dist[node.getV()]) {
                flag = 1;
                System.out.println("Negative cycle present");
                break;
            }
        }

        if(flag == 0) {
            for(int i=0; i<n; i++) {
                System.out.println(i + " " + dist[i]);
            }
        }
    }

    public static void main(String args[]) {
        int n = 6;
        ArrayList<Node> adj = new ArrayList<>();

        adj.add(new Node(3,2,6));
        adj.add(new Node(5,3,1));
        adj.add(new Node(0,1,5));
        adj.add(new Node(1,5,-3));
        adj.add(new Node(1,2,-2));
        adj.add(new Node(3,4,-2));
        adj.add(new Node(2,4,3));

        BellmanFord obj = new BellmanFord();
        obj.run(adj, n, 0);
    }

}
