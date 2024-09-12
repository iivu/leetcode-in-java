package questions.n1670_frontMiddleBackQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static class FrontMiddleBackQueue {

        private final Deque<Integer> left = new LinkedList<>();
        private final Deque<Integer> right = new LinkedList<>();

        // 平衡函数，始终维持left中的元素比right少一个
        // 每次增删以后都要调用一次
        private void balance() {
            if (right.size() > left.size() + 1) {
                left.addLast(right.removeFirst());
            }
            if (left.size() > right.size()) {
                right.addFirst(left.removeLast());
            }
        }

        private int size() { return left.size() + right.size(); }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (size() % 2 == 0) {
                right.addFirst(val);
            } else {
                left.addLast(val);
            }
            balance();
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (size() == 0) {
                return -1;
            }
            if (size() == 1) {
                return right.removeFirst();
            }
            int value = left.removeFirst();
            balance();
            return value;
        }

        public int popMiddle() {
            if (size() == 0) {
                return -1;
            }
            int value;
            if (size() % 2 == 0) {
                value = left.removeLast();
            } else {
                value = right.removeFirst();
            }
            return value;
        }

        public int popBack() {
            if (size() == 0) {
                return -1;
            }
            int value = right.removeLast();
            balance();
            return value;
        }
    }
}
