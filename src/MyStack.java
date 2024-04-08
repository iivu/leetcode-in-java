import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {
    private Deque<Integer> queue = new ArrayDeque<>();

    public MyStack() {

    }

    public void push(int x) {
        int n = queue.size();
        queue.offer(x);
        for (int i = 0; i < n; ++i) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
