package questions;

import java.util.Random;

// 堆排序
class SolutionN912_1 {
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

// 选择排序
class SolutionN912_2 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// 冒泡排序
class SolutionN912_3 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// 归并排序
class SolutionN912_4 {
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

// 快速排序（数组越有序，效果越差）
class SolutionN912_5 {
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

// 快速排序（双指针优化）
class SolutionN912_6 {
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

    public void swap(int[] nums, int index1, int index2) {
        if (index1 == index2)
            return;
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}

// 快速排序（双指针优化，随机pivot）
class SolutionN912_7 {
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

// 计数排序，需要注意元素中有负数的情况（log（N+K））
class SolutionN912_8 {
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

// 基数排序，基于计数排序
class SolutionN912_9 {
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

// 桶排序
class SolutionN912_10 {
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