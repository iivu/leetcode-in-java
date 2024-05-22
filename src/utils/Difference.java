package utils;

// 差分数组工具
public class Difference {
    private final int[] diff;

    public Difference(int[] arr) {
        assert arr.length > 0;
        diff = new int[arr.length];
        diff[0] = arr[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
    }

    // 区间[i,j]内的元素加val
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] getArray() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}
