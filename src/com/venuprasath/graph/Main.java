package com.venuprasath.graph;

import com.venuprasath.graph.common.Vertex;
import com.venuprasath.graph.dfs.DFS;
import com.venuprasath.graph.directed_graph.CycleDetection;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Vertex<Integer> v0 = new Vertex<Integer>(0);
        Vertex<Integer> v1 = new Vertex<Integer>(1);
        Vertex<Integer> v2 = new Vertex<Integer>(2);
        Vertex<Integer> v3 = new Vertex<Integer>(3);
        Vertex<Integer> v4 = new Vertex<Integer>(4);
        Vertex<Integer> v5 = new Vertex<Integer>(5);
        Vertex<Integer> v6 = new Vertex<Integer>(6);

        v0.neighbours = Arrays.asList(v1, v5, v6);
        v1.neighbours = Arrays.asList(v3, v4, v5);
        v4.neighbours = Arrays.asList(v2, v6);
        v6.neighbours = Arrays.asList(v0);

        //BFS bfs = new BFS(v0);
        //bfs.traverse();

        //DFS dfs = new DFS(v0);
        //dfs.traverse();
        //dfs.traverseRecursively(v0);

        //Directed graph is cyclic?
        CycleDetection cycleDetection = new CycleDetection();
        cycleDetection.createGraph();
        System.out.println("Graph is Cyclic: " +
                cycleDetection.graphIsCyclic());
    }
}
