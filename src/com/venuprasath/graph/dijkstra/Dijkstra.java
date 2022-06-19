package com.venuprasath.graph.dijkstra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {
    int v;
    int weight;

    Node(int _v, int _w) { v = _v; weight = _w; }

    Node() {}

    int getV() {return v; }
    int getWeight() { return weight; }

    @Override
    public int compare(Node node1, Node node2) {
        return Integer.compare(node1.weight, node2.weight);
    }
}

public class Dijkstra {

    void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int N) {
        int dist[] = new int[N];

        for(int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[s] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(N, new Node());
        pq.add(new Node(s, 0));

        while(pq.size() > 0) {
            Node node = pq.poll();

            for(Node it: adj.get(node.getV())) {
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]) {
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        for(int i=0; i< N; i++) {
            System.out.println(dist[i] + " ");
        }
    }


    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
           adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node(1,2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2,4));
        adj.get(2).add(new Node(1,4));

        adj.get(0).add(new Node(3,1));
        adj.get(3).add(new Node(0,1));

        adj.get(3).add(new Node(2,3));
        adj.get(2).add(new Node(3,3));

        adj.get(1).add(new Node(4,5));
        adj.get(4).add(new Node(1,5));

        adj.get(2).add(new Node(4,1));
        adj.get(4).add(new Node(2,1));

        Dijkstra obj = new Dijkstra();
        obj.shortestPath(0, adj, n);
    }
}
