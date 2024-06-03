package questions.n912_sortArray;

// 桶排序
public class BoxSort {
    public int[] sortArray(int[] nums) {
        bucketSort(nums);
        return nums;
    }

    private void bucketSort(int[] nums) {
        int len = nums.length;
        int maxNum = 0;
        int minNum = 0;
        for (int num : nums) {
            maxNum = Math.max(num, maxNum);
            minNum = Math.min(num, minNum);
        }
        int step = Math.max(Math.min((int) Math.pow(10, getMaxDigits(maxNum - minNum) - 1), 1000), 10);
        int bucketLen = (maxNum - minNum) / step + 1;
        int[][] buckets = new int[bucketLen][len];
        int[] bucketElementsCount = new int[bucketLen];
        for (int num : nums) {
            int bucketIndex = (num - minNum) / step;
            buckets[bucketIndex][bucketElementsCount[bucketIndex]] = num;
            bucketElementsCount[bucketIndex]++;
        }
        for (int i = 0; i < buckets.length; i++) {
            int[] bucket = buckets[i];
            selectSort(bucket, bucketElementsCount[i] - 1);
        }

        int current = 0;
        for (int i = 0; i < bucketLen; i++) {
            for (int j = 0; j < bucketElementsCount[i]; j++) {
                nums[current] = buckets[i][j];
                current++;
            }
        }

    }

    private void selectSort(int[] nums, int end) {
        for (int i = 1; i <= end; i++) {
            if (nums[i] < nums[i - 1]) {
                int j = i;
                while (j > 0 && nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                    j--;
                }
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    private int getMaxDigits(int num) {
        num = Math.abs(num);
        int digits = 0;
        while (num > 0) {
            num /= 10;
            digits++;
        }
        return digits;
    }
}
