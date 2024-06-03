package questions.n912_sortArray;

// 基数排序，基于计数排序
public class RadixSort {
    public int[] sortArray(int[] nums) {
        int maxAbs = 0;
        for (int num : nums) {
            maxAbs = Math.max(Math.abs(num), maxAbs);
        }
        int maxDigits = getMaxDigits(maxAbs);
        int divisor = 1;
        for (int i = 0; i < maxDigits; i++) {
            countSort(nums, divisor);
            divisor *= 10;
        }
        return nums;
    }

    // nums的元素会出现负数，因此需要把负数映射到正数范围内
    public void countSort(int[] nums, int divisor) {
        int len = nums.length;
        int[] temp = new int[len];
        int max = 0;
        int min = 0;
        System.arraycopy(nums, 0, temp, 0, len);
        for (int num : nums) {
            max = Math.max(getDigit(num, divisor), max);
            min = Math.min(getDigit(num, divisor), min);
        }
        int[] countArr = new int[max - min + 1];
        for (int num : nums) {
            countArr[getDigit(num, divisor) - min]++;
        }
        for (int i = 1; i < countArr.length; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            int num = temp[i];
            int countArrIndex = getDigit(num, divisor) - min;
            int sortedIndex = countArr[countArrIndex] - 1;
            nums[sortedIndex] = num;
            countArr[countArrIndex]--;
        }
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

    private int getDigit(int num, int divisor) {
        return (num / divisor) % 10;
    }
}
