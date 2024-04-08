package utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyQueue {
    private Deque<Integer> stackPush = new ArrayDeque<>();
    private Deque<Integer> stackPop = new ArrayDeque<>();

    public MyQueue() {

    }

    public void push(int x) {
        stackPush.push(x);
    }

    public int pop() {
        fillStackPop();
        return stackPop.pop();
    }

    public int peek() {
        fillStackPop();
        return stackPop.peek();
    }

    public boolean empty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }

    private void fillStackPop() {
        if (!stackPop.isEmpty()) return;
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
    }
}
