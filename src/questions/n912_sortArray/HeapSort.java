package questions.n912_sortArray;

// 堆排序
public class HeapSort {
    public int[] sortArray(int[] nums) {
        heapify(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            siftDown(nums, 0, i - 1);
        }
        return nums;
    }

    private void heapify(int[] data) {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            siftDown(data, i, data.length - 1);
        }
    }

    private void siftDown(int[] data, int k, int end) {
        while (k * 2 + 1 <= end) {
            // 左边子节点
            int j = k * 2 + 1;
            if (j + 1 <= end && data[j + 1] > data[j]) {
                // 右节点大于了左节点
                j++;
            }
            if (data[k] > data[j]) {
                break;
            }
            swap(data, j, k);
            k = j;
        }
    }

    private void swap(int[] data, int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }
}
