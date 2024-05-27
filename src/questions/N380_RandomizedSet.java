package questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实现RandomizedSet 类：
 * <p>
 * RandomizedSet() 初始化 RandomizedSet 对象
 * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
 * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
 * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。
 */
class SolutionN380 {
    public static class RandomizedSet {

        private final Map<Integer, Integer> memo;
        private final List<Integer> data;

        public RandomizedSet() {
            memo = new HashMap<>();
            data = new ArrayList<>();
        }

        public boolean insert(int val) {
            if (memo.containsKey(val)) {
                return false;
            }
            data.addLast(val);
            memo.put(val, data.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            if (!memo.containsKey(val)) {
                return false;
            }
            int index = memo.get(val);
            // 将需要删除掉元素交换到数组最后删除
            // 同时更新相关信息
            memo.put(data.getLast(), index);
            swap(data, index, data.size() - 1);
            data.removeLast();
            memo.remove(val);
            return true;
        }

        public int getRandom() {
            return data.get((int) (Math.random() * data.size()));
        }

        private void swap(List<Integer> data, int index1, int index2) {
            int temp = data.get(index1);
            data.set(index1, data.get(index2));
            data.set(index2, temp);
        }
    }
}