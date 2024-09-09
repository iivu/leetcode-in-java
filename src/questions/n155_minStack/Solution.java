package questions.n155_minStack;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static class MinStack {

        private final Deque<Integer> stack = new LinkedList<>();
        private final Deque<Integer> minStack = new LinkedList<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.addLast(val);
            if (minStack.isEmpty() || val <= minStack.getLast()) {
                minStack.addLast(val);
            }
        }

        public void pop() {
            if (minStack.getLast().equals(stack.getLast())) {
                minStack.removeLast();
            }
            stack.removeLast();
        }

        public int top() {
            return stack.getLast();
        }

        public int getMin() {
            return minStack.getLast();
        }
    }
}
