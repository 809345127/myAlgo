package com.shize.algo;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] data;

    private int capacity;

    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public void add(T ele) {
        if (size == capacity) {
            resize();
        }
        data[size++] = ele;
    }

    private void resize() {
        capacity = capacity * 2;
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }
}
