package com.venuprasath.heap;

import java.util.Arrays;

public class MinHeap<T extends Comparable<T>> {
    private int capacity;
    private int size;
    T[] items;
    MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        items = (T[]) new Comparable[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private T leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private T rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private T parent(int index) {
        return items[getParentIndex(index)];
    }

    private void swap(int indexOne, int indexTwo) {
        T temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureCapacity() {
        if(size == capacity) {
            capacity *= 2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    public T peek() {
        if(size == 0) throw new IllegalStateException();
        return items[0];
    }

    public T poll() {
        if(size == 0) throw new IllegalStateException();
        T item = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(T item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size-1;
        while(hasParent(index) && items[index].compareTo(parent(index)) < 0) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) < 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if(items[index].compareTo(items[smallerChildIndex]) < 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }



}