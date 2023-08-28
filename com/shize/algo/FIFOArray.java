package com.shize.algo;

/**
 * 数组实现的队列，先进先出
 */
public class FIFOArray {
    private int[] items;

    private int count;

    private int capacity;

    public FIFOArray(int capacity) {
        this.capacity = capacity;
        this.items = new int[capacity];
        this.count = 0;
    }

    public boolean push(int item) {
        if (count == capacity) {
            return false;
        }
        items[count++] = item;
        return true;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }

        int res = items[0];

        // 删除第一个
        // 8 0 1 4 x x x
        // 0 1 2 3 x x x
        for (int i = 0; i < count - 1; i++) {
            items[i] = items[i + 1];
        }

        count --;
        return res;
    }

    public static void main(String[] args) {
        FIFOArray FIFOArray = new FIFOArray(10);
        FIFOArray.push(5);
        FIFOArray.push(9);
        FIFOArray.push(512);
        FIFOArray.push(51);

        while (true) {
            int pop = FIFOArray.pop();
            if (pop == -1) {
                break;
            }
            System.out.println(pop);
        }
    }
}
