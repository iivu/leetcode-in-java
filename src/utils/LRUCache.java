package utils;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        lRUCache.get(1);    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.get(2);    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lRUCache.get(1);    // 返回 -1 (未找到)
        lRUCache.get(3);    // 返回 3
        lRUCache.get(4);    // 返回 4
    }

    private static final class Node {
        public int key;
        public int value;
        public Node next;
        public Node prev;

        public Node(int key, int value) {
            this(key, value, null, null);
        }

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node latest = null;
    private final Node oldestHead = new Node(-1, -1, null, null);
    private final Map<Integer, Node> cache = new HashMap<>();
    private int capacity = 10;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            activeNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            activeNode(node);
            return;
        }
        Node node = new Node(key, value);
        if (oldestHead.next == null) {
            oldestHead.next = node;
            node.prev = oldestHead;
        }
        if (latest != null) {
            latest.next = node;
            node.prev = latest;
        }
        latest = node;
        cache.put(key, node);
        if (cache.size() > capacity) {
            cache.remove(oldestHead.next.key);
            Node temp = oldestHead.next;
            temp.next.prev = oldestHead;
            oldestHead.next = temp.next;
            temp.next = temp.prev = null;
        }
    }

    private void activeNode(Node node) {
        if (node.next == null) {
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = latest;
        latest.next = node;
        node.next = null;
        latest = node;
    }
}
