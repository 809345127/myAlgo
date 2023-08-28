package com.shize.algo;

/**
 * 有序数组
 * 最小的放最前面
 */
public class OrderArrayList {
    private static final int DEFAULT_CAPACITY = 10;

    private int[] data;

    private int capacity;

    private int size = 0;

    public OrderArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public OrderArrayList(int capacity) {
        this.capacity = capacity;
        this.data = new int[capacity];
    }

    public void add(int ele) {
        if (size == capacity) {
            throw new RuntimeException("out of bound");
        }
        // 找到第一个比ele大的元素，将其后面的元素都往后移动一位
        int index = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > ele) {
                index = i;
                break;
            }
        }

        for (int i = data.length - 1; i > index; i--) {
            data[i] = data[i - 1];
        }


        // 0 1 2 3 4 5
        // 6 7 8 9 5 6



    }
}
