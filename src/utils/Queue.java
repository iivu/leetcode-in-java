package utils;

public interface Queue {
    boolean isEmpty();

    int size();

    void offer(int x);

    int poll();

    int peek();
}
