package questions;

import utils.ListNode;
import utils.MinHeap;

import java.util.Comparator;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dump = new ListNode(-1);
        ListNode curr = dump;
        MinHeap<ListNode> minHeap = new MinHeap<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.peek();
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