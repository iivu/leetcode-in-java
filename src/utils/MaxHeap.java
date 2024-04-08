package utils;

public class MaxHeap implements Queue {
    /**
     * 将完全二叉树放在数组中表示，父子节点的下标有一定的关系
     * 树从上到下，从左到右，打平放在data中，data[0]不放置元素，从data[1]开始
     * 父节点： i / 2
     * 子节点左：i * 2
     * 子节点右：i * 2 + 1
     */
    private final int[] data;
    private int capacity = 0;
    private int size = 0;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.data = new int[capacity + 1];
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void offer(int x) {
        if (size + 1 > capacity) {
            throw new IllegalArgumentException("The heap is already full.");
        }
        data[++size] = x;
        siftUp(size);
    }

    @Override
    public int poll() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        int v = data[1];
        data[1] = data[size];
        size--;
        siftDown(1);
        return v;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        return data[1];
    }

    public void replace(int x) {
        if (isEmpty()) {
            throw new IllegalArgumentException("The heap is empty.");
        }
        data[1] = x;
        siftDown(1);
    }

    // 逐层比较父元素
    private void siftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            swap(data, k, k / 2);
            k = k / 2;
        }
    }

    // 逐层比较子元素
    private void siftDown(int k) {
        while (k * 2 <= size) {
            // 先从左节点开始
            int j = k * 2;
            if (j + 1 <= size && data[j + 1] > data[j]) {
                // 右边节点大于了左边节点
                ++j;
            }
            if (data[k] >= data[j]) {
                break;
            }
            swap(data, k, j);
            k = j;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
