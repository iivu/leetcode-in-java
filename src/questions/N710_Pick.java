package questions;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数 n 和一个 无重复 黑名单整数数组 blacklist 。设计一种算法，从 [0, n - 1] 范围内的任意整数中选取一个 未加入 黑名单 blacklist 的整数。任何在上述范围内且不在黑名单 blacklist 中的整数都应该有 同等的可能性 被返回。
 * <p>
 * 优化你的算法，使它最小化调用语言 内置 随机函数的次数。
 * <p>
 * 实现 Solution 类:
 * <p>
 * Solution(int n, int[] blacklist) 初始化整数 n 和被加入黑名单 blacklist 的整数
 * int pick() 返回一个范围为 [0, n - 1] 且不在黑名单 blacklist 中的随机整数
 */
class SolutionN710 {
    public static class Pick {
        private final int size;
        private final Map<Integer, Integer> memo;

        public Pick(int n, int[] blacklist) {
            size = n - blacklist.length;
            memo = new HashMap<>();
            for (int b : blacklist) {
                // 预先把黑名单放进memo
                memo.put(b, 621);
            }
            int last = n - 1;
            for (int b : blacklist) {
                if (b >= size) {
                    // 如果黑名单已经在数组末尾了，则跳过
                    continue;
                }
                while (memo.containsKey(last)) {
                    // 跳过本身也是黑名单的映射
                    last--;
                }
                memo.put(b, last);
                last--;
            }
        }

        public int pick() {
            int index = (int) (Math.random() * size);
            if (memo.containsKey(index)) {
                return memo.get(index);
            }
            return index;
        }
    }
}