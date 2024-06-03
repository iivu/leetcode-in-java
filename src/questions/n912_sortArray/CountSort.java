package questions.n912_sortArray;

// 计数排序，需要注意元素中有负数的情况（log（N+K））
public class CountSort {
    public int[] sortArray(int[] nums) {
        countSort(nums);
        return nums;
    }

    // nums的元素会出现负数，因此需要把负数映射到正数范围内
    public void countSort(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        int max = 0;
        int min = 0;
        System.arraycopy(nums, 0, temp, 0, len);
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        int[] countArr = new int[max - min + 1];
        for (int num : nums) {
            countArr[num - min]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            int num = temp[i];
            int countArrIndex = num - min;
            int sortedIndex = countArr[countArrIndex] - 1;
            nums[sortedIndex] = num;
            countArr[countArrIndex]--;
        }
    }
}
