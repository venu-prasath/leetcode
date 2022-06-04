package com.venuprasath.graph.topological_sort;

import com.venuprasath.graph.common.Vertex;

import java.util.Deque;
import java.util.LinkedList;

public class TopologicalSort {

    Vertex<Integer> startVertex;

    public TopologicalSort(Vertex<Integer> vertex) {
        startVertex = vertex;
    }

    public Deque<Vertex<Integer>> dfs(Vertex<Integer> neigh) {
        Deque<Vertex<Integer>> stack = new LinkedList<>();
        if(!neigh.isVisited) {
            neigh.isVisited = true;
            System.out.println(neigh.data.toString());
            neigh.neighbours.forEach( neighbour -> {
                if(!neighbour.isVisited) {
                    dfs(neighbour);
                }
            });
            stack.push(neigh);
            System.out.println("Data: " + neigh.data);
            return stack;
        }
        return stack;
    }

}
