package questions.n346_MovingAverage;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。
 * <p>
 * 实现 MovingAverage 类：
 * <p>
 * MovingAverage(int size) 用窗口大小 size 初始化对象。
 * double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。
 */
public class Solution {
    public static class MovingAverage {
        public int size;
        private final Deque<Integer> queue;

        public MovingAverage(int size) {
            this.size = size;
            queue = new LinkedList<>();
        }

        public double next(int val) {
            if (!queue.isEmpty() && queue.size() >= size) {
                queue.poll();
            }
            queue.offer(val);
            return (double) queue.stream().mapToInt(v -> v).sum() / queue.size();
        }
    }
}
