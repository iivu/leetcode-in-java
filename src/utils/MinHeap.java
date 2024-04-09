package utils;

import java.util.Comparator;

public class MinHeap<T> {
    private final T[] data;
    private int capacity = 0;
    private int size = 0;
    private Comparator<T> cmp;

    public MinHeap(int capacity, Comparator<T> cmp) {
        this.capacity = capacity;
        this.size = 0;
        this.cmp = cmp;
        this.data = (T[]) new Object[capacity + 1];
    }

    public MinHeap(T[] arr, Comparator<T> cmp) {
        size = capacity = arr.length;
        data = (T[]) new Object[capacity + 1];
        this.cmp = cmp;
        System.arraycopy(arr, 0, data, 1, size);
//         自顶向下将数组整理成堆，效率较低O(NlogN)
//        for (int i = 2; i <= size; i++) {
//            siftUp(i);
//        }
//        自底向上将数组整理成堆，效率较高O(N)
        for (int i = size / 2; i >= 1; i--) {
            siftDown(i);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void offer(T x) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("The heap is already full.");
        }
        data[++size] = x;
        siftUp(size);
    }

    public T poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        T v = data[1];
        data[1] = data[size];
        size--;
        siftDown(1);
        return v;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        return data[1];
    }

    public void replace(T x) {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        data[1] = x;
        siftDown(1);
    }

    // 逐层比较父元素
    private void siftUp(int k) {
        while (k > 1 && cmp.compare(data[k / 2], data[k]) > 0) {
            swap(data, k, k / 2);
            k = k / 2;
        }
    }

    // 逐层比较子元素
    private void siftDown(int k) {
        while (k * 2 <= size) {
            // 先从左节点开始
            int j = k * 2;
            if (j + 1 <= size && cmp.compare(data[j + 1], data[j]) < 0) {
                // 右边节点小于了左边节点
                ++j;
            }
            if (cmp.compare(data[k],data[j]) <= 0) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void swap(T[] data, int index1, int index2) {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
