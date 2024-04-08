package utils;

import java.lang.constant.DynamicCallSiteDesc;
import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    private static class Node {
        public int key, value, freq;
        public Node next, prev;

        public Node(int key, int value) {
            this(key, value, null, null);
        }

        public Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
            this.freq = 1;
        }
    }

    private static class DoublyLinkedList {
        private final Node dumpHead, dumpTail;
        private int size = 0;

        public DoublyLinkedList() {
            dumpHead = new Node(-1, -1, null, null);
            dumpTail = new Node(-1, -1, null, null);
            dumpHead.next = dumpTail;
            dumpTail.prev = dumpHead;
        }

        public int size() {
            return size;
        }

        public void add(Node node) {
            Node temp = dumpTail.prev;
            dumpTail.prev = node;
            node.next = dumpTail;
            temp.next = node;
            node.prev = temp;
            ++size;
        }

        public Node removeOldest() {
            if (size == 0) return dumpHead;
            Node temp = dumpHead.next;
            dumpHead.next = temp.next;
            temp.next.prev = dumpHead;
            temp.next = null;
            temp.prev = null;
            --size;
            return temp;
        }

        public void remove(Node node) {
            if (size == 0) return;
            Node prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        public Node head() {
            return dumpHead.next;
        }

        public Node tail() {
            return dumpTail.prev;
        }
    }

    private final Map<Integer, Node> cache = new HashMap<>();
    private final Map<Integer, DoublyLinkedList> freqCache = new HashMap<>();
    private int capacity = 10;
    private int minFreq = 1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            updateNodeFreq(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            cache.put(key, node);
            updateNodeFreq(node);
            return;
        }
        Node node = new Node(key, value);
        DoublyLinkedList freqList = freqCache.computeIfAbsent(1, k -> new DoublyLinkedList());
        freqList.add(node);
        cache.put(key, node);
        if (cache.size() > capacity) {
            DoublyLinkedList needDeleteFreqList = freqCache.get(minFreq);
            Node needToDeleteNode = needDeleteFreqList.removeOldest();
            cache.remove(needToDeleteNode.key);
        }
        minFreq = 1;
    }

    private void updateNodeFreq(Node node) {
        DoublyLinkedList currFreqList = freqCache.computeIfAbsent(node.freq, k -> new DoublyLinkedList());
        DoublyLinkedList nextFreqList = freqCache.computeIfAbsent(node.freq + 1, k -> new DoublyLinkedList());
        currFreqList.remove(node);
        nextFreqList.add(node);
        if (currFreqList.size() == 0 && minFreq == node.freq) {
            minFreq = node.freq + 1;
        }
        ++node.freq;
    }
}
