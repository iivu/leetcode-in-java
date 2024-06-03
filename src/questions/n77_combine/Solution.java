package questions.n77_combine;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
class Solution {
    private final List<List<Integer>> ans = new LinkedList<>();
    private final List<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, 1, k);
        return ans;
    }

    public void backtrack(int n, int start, int k) {
        if (track.size() == k) {
            // 当前所做的选择已经满足条件了
            ans.add(new LinkedList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            // 做选择
            track.addLast(i);
            // 进入下一个选择
            backtrack(n, i + 1, k);
            // 撤销选择
            track.removeLast();
        }
    }
}