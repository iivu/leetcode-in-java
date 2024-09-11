package questions.n362_hitCounter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 设计一个敲击计数器，使它可以统计在过去 5 分钟内被敲击次数。（即过去 300 秒）
 * <p>
 * 您的系统应该接受一个时间戳参数 timestamp (单位为 秒 )，并且您可以假定对系统的调用是按时间顺序进行的(即 timestamp 是单调递增的)。几次撞击可能同时发生。
 * <p>
 * 实现 HitCounter 类:
 * <p>
 * HitCounter() 初始化命中计数器系统。
 * void hit(int timestamp) 记录在 timestamp ( 单位为秒 )发生的一次命中。在同一个 timestamp 中可能会出现几个点击。
 * int getHits(int timestamp) 返回 timestamp 在过去 5 分钟内(即过去 300 秒)的命中次数。
 */

public class Solution {
    public static class HitCounter {

        private final Deque<Integer> queue = new LinkedList<>();

        public HitCounter() {

        }

        public void hit(int timestamp) {
            queue.addLast(timestamp);
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.getFirst() >= 300) {
                queue.removeFirst();
            }
            return queue.size();
        }
    }
}
