package com.venuprasath.graph.common;

import java.util.LinkedList;
import java.util.List;

public class Vertex<T> {
    public T data = null;
    public boolean isVisited = false;
    public List<Vertex<T>> neighbours = new LinkedList<>();

    public Vertex(T i) {
        data = i;
    }
}
