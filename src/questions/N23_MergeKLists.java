package questions;

import utils.SinglyLinkedList;
import utils.MinHeap;

import java.util.Comparator;

class Solution {
    public static class LisNode {
        public int val;
        private LisNode next;

        LisNode(int val){
            this.val = val;
        }
    }

    public LisNode mergeKLists(LisNode[] lists) {
        LisNode dump = new LisNode(-1);
        LisNode curr = dump;
        MinHeap<LisNode> minHeap = new MinHeap<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (LisNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            LisNode top = minHeap.peek();
            curr.next = top;
            curr = top;
            if (top.next == null) {
                minHeap.poll();
            } else {
                minHeap.replace(top.next);
            }
        }
        return dump.next;
    }
}