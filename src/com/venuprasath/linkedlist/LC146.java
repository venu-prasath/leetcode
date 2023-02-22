package com.venuprasath.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LC146 {

    public static void main(String[] args) {

    }
}

class LRUCache {
    Map<Integer, DoublyNode> map = null;
    DoublyLinkedList list = null;
    int capacity = 0;
    int currentCapacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        list = new DoublyLinkedList();
    }

    public int get(int key) {
        System.out.println("get called: "+key);
        if(!map.containsKey(key)) return -1;
        DoublyNode node = map.get(key);
        list.remove(node);
        list.addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        System.out.println("put called for key: "+key);
        if(map.containsKey(key)) {
            DoublyNode node = map.get(key);
            list.remove(node);
            node.val = value;
            list.addFirst(node);
        } else {
            DoublyNode node = new DoublyNode(key, value);
            map.put(key, node);
            list.addFirst(node);
            currentCapacity++;
            if(currentCapacity > capacity) {
                DoublyNode lastNode = list.removeLast();
                System.out.println(lastNode.key);
                map.remove(lastNode.key);
            }
        }
    }
}

class DoublyLinkedList {
    DoublyNode head = null;
    DoublyNode tail = null;

    DoublyLinkedList() {
        this.head = new DoublyNode(-1, -1);
        this.tail = new DoublyNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void addFirst(DoublyNode node) {
        System.out.println("addFirst for "+ node.val);
        node.next = head.next;
        node.prev = head;
        head.next = node;
        node.next.prev = node;
    }

    public void remove(DoublyNode node) {
        System.out.println("remove for " + node.val);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    public DoublyNode removeLast() {
        DoublyNode lastNode = tail.prev;
        remove(tail.prev);
        return lastNode;
    }
}

class DoublyNode {
    int val;
    int key;
    DoublyNode prev = null;
    DoublyNode next = null;


    DoublyNode(int key, int val) {
        this.val = val;
        this.key = key;
    }
}

