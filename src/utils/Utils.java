package utils;

import java.util.ArrayList;
import java.util.List;

public final class Utils {
    private Utils() {
    }

    public static List<List<Integer>> nSumTarget(int[] data, int n, int start, long target) {
        List<List<Integer>> res = new ArrayList<>();
        if (start == data.length) {
            return res;
        }
        long average = target / n;
        // 平均数检测
        // 如果start大于了平均数，或者 data.length - 1 小于了平均数，那么在[start, data.length - 1]中就不可能有找到nSum
        if (data[start] > average || average > data[data.length - 1]) {
            return res;
        }
        if (n == 2) {
            int l = start, r = data.length - 1;
            while (l < r) {
                int left = data[l], right = data[r];
                int sum = left + right;
                if (sum < target) {
                    while (l < r && data[l] == left) {
                        l++;
                    }
                } else if (sum > target) {
                    while (l < r && data[r] == right) {
                        r--;
                    }
                } else {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(data[l]);
                    ans.add(data[r]);
                    res.add(ans);
                    while (l < r && data[l] == left) {
                        l++;
                    }
                    while (l < r && data[r] == right) {
                        r--;
                    }
                }
            }
        } else {
            for (int i = start; i < data.length; i++) {
                for (List<Integer> sub : nSumTarget(data, n - 1, i + 1, target - data[i])) {
                    sub.add(data[i]);
                    res.add(sub);
                }
                while (i < data.length - 1 && data[i] == data[i + 1]) {
                    i++;
                }
            }
        }
        return res;
    }
}
