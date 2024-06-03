package questions.n912_sortArray;

import java.util.Random;

// 快速排序（双指针优化，随机pivot）
class QuickSort3 {
    public Random random = new Random();

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(nums, left, right);
        quickSort(nums, left, pivotIndex - 1);
        quickSort(nums, pivotIndex + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        randomPivot(nums, left, right);
        int pivot = nums[left];
        // pivot >= [left+1, le) , pivot <= (ge,right]
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    public void randomPivot(int[] nums, int left, int right) {
        int i = random.nextInt(right - left + 1) + left;
        swap(nums, left, i);
    }

    public void swap(int[] nums, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}