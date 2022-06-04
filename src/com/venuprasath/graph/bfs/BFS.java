package com.venuprasath.graph.bfs;

import com.venuprasath.graph.common.Vertex;

import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> {



    Vertex<T> startVertex = null;

    public BFS(Vertex<T> v) {
        startVertex = v;
    }

    public void traverse() {
        System.out.println("BFS traversal");
        if(startVertex != null) {
            Queue<Vertex<T>> queue = new LinkedList<>();
            queue.add(startVertex);
            while(!queue.isEmpty()) {
                Vertex<T> current = queue.poll();
                if(!current.isVisited) {
                    current.isVisited = true;
                    System.out.println(current.data.toString());
                    queue.addAll(current.neighbours);
                }
            }
        }
   }
}
