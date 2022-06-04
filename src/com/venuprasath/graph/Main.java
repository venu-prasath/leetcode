package com.venuprasath.graph;

import com.venuprasath.graph.common.Vertex;
import com.venuprasath.graph.directed.CycleDetection;
import com.venuprasath.graph.topological_sort.TopologicalSort;
import com.venuprasath.graph.undirected.UndirectedGCycleDetection;

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

        v0.neighbours = Arrays.asList(v1, v3, v4);
        v1.neighbours = Arrays.asList(v2);
        v3.neighbours = Arrays.asList(v4);
        v4.neighbours = Arrays.asList(v2);

        //BFS bfs = new BFS(v0);
        //bfs.traverse();

        //DFS dfs = new DFS(v0);
        //dfs.traverse();
        //dfs.traverseRecursively(v0);

        //Directed graph is cyclic?
        //CycleDetection cycleDetection = new CycleDetection();
        //cycleDetection.createGraph();
        //System.out.println("Graph is Cyclic: " + cycleDetection.graphIsCyclic());

        //UndirectedGCycleDetection cycleDetection = new UndirectedGCycleDetection();
        //cycleDetection.createGraph();
        //System.out.println("Graph is Cyclic: " + cycleDetection.isGraphCyclic(0, -1));

        TopologicalSort topologicalSort = new TopologicalSort(v0);
        topologicalSort.dfs(v0);
    }
}
