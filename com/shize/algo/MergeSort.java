package com.shize.algo;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 10, 3, 5, 1, 4, 2 };

        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void mergeSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = (p + r) / 2;
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }

    private static void merge(int[] arr, int p, int q, int r) {
        // 新建一个临时数组，大小为q-p+1
        int[] tmp = new int[r - p + 1];

        // 将arr[p...r]和arr[r+1...q]合并，依次比较，从小到大放入tmp数组中
        int i = p;
        int j = q + 1;
        int k = 0;
        while (i <= q && j <= r) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }

        // 判断哪个子数组中有剩余的数据，并将剩余数据拷贝到临时数组tmp中
        // 先假设arr[p...q]中还有剩余数据，所以start = i, end = q
        int start = i;
        int end = q;
        // 如果arr[r+1...q]中还有剩余数据，则start = j, end = r
        if (j <= r) {
            start = j;
            end = r;
        }

        // 将剩余数据拷贝到临时数组tmp中
        while (start <= end) {
            tmp[k++] = arr[start++];
        }

        // 将tmp中的数据拷贝回arr中
        for (int l = 0; l < tmp.length; l++) {
            arr[p + l] = tmp[l];
        }
    }

}
