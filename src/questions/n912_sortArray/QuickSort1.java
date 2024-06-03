package questions.n912_sortArray;

// 快速排序（数组越有序，效果越差）
class QuickSort1 {
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
        int pivot = nums[left];
        int lt = left;
        int i = left + 1;
        while (i <= right) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
            i++;
        }
        swap(nums, left, lt);
        return lt;
    }

    public void swap(int[] nums, int index1, int index2) {
        if (index1 == index2) return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
