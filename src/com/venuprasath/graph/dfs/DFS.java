package com.venuprasath.graph.dfs;

import com.venuprasath.graph.common.Vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DFS<T> {

    Vertex<T> startVertex = null;

    public DFS(Vertex<T> v) {
        startVertex = v;
    }

    public void traverse() {
        System.out.println("DFS traversal");
        if(startVertex != null) {
            Deque<Vertex<T>> stack = new LinkedList<>();
            stack.push(startVertex);
            while(!stack.isEmpty()) {
                Vertex<T> current = stack.pop();
                if(!current.isVisited) {
                    current.isVisited = true;
                    System.out.println(current.data.toString());
                    Collections.reverse(current.neighbours);
                    current.neighbours.forEach(stack::push);
                }
            }
        }
    }

    public void traverseRecursively(Vertex<T> vertex) {
        vertex.isVisited = true;
        System.out.println(vertex.data.toString());
        vertex.neighbours.forEach(neighbour -> {
                if(!neighbour.isVisited) {
                    traverseRecursively(neighbour);
                }
            }
        );
    }
}
