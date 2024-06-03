package questions.n912_sortArray;

// 归并排序
public class MergeSort {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        mergeTwoSortedArray(nums, left, mid, right);
    }

    private void mergeTwoSortedArray(int[] nums, int left, int mid, int right) {
        int len = right - left + 1;
        int[] temp = new int[len];
        System.arraycopy(nums, left, temp, 0, len);
        // [left, mid]~[mid + 1, right]两个有序区间
        int i = 0;
        int j = mid - left + 1;
        int k = left;
        while (k <= right) {
            if (j >= len) {
                nums[k] = temp[i];
                i++;
            } else if (i == (mid - left + 1)) {
                nums[k] = temp[j];
                j++;
            } else if (temp[i] > temp[j]) {
                nums[k] = temp[j];
                j++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            }
            k++;
        }
    }
}
