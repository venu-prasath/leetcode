package com.venuprasath.graph.tarjans;

import java.util.List;
import java.util.Vector;

public class Tarjans<T> {
    Integer nodeSize = null;
    List<Vector<T>> connections = null;
    
    Tarjans(Integer n, List<Vector<T>> cons) {
        nodeSize = n;
        connections = cons;
    }

    void findBridgesWithTarjans() {

    }
}
