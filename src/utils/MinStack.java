package utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(2147483646);
        ms.push(2147483646);
        ms.push(2147483647);
        ms.top();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.getMin();
        ms.pop();
        ms.push(2147483647);
        ms.top();
        ms.getMin();
        ms.push(-2147483648);
        ms.top();
        ms.getMin();
        ms.pop();
        ms.getMin();
    }

    private final Deque<Long> diffStack = new ArrayDeque<>();
    private long minValue = -1;

    public MinStack() {

    }

    public void push(int val) {
        if (diffStack.isEmpty()) {
            minValue = val;
            diffStack.push(0L);
        } else {
            long diff = val - minValue;
            if (diff <= 0) {
                minValue = val;
            }
            diffStack.push(diff);
        }
    }

    public void pop() {
        long top = diffStack.pop();
        if (top < 0) {
            minValue = minValue - top;
        }
    }

    public int top() {
        long topDiff = diffStack.peek();
        if (topDiff >= 0) {
            return (int) (topDiff + minValue);
        } else {
            return (int) (minValue - topDiff);
        }
    }

    public long getMin() {
        return minValue;
    }
}
