package questions.n1836_deleteDuplicates2;

import utils.ListNode;

import java.util.HashMap;

import java.util.Map;

/**
 * 给定一个链表的第一个节点 head ，找到链表中所有出现多于一次的元素，并删除这些元素所在的节点。
 * <p>
 * 返回删除后的链表。
 */
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Map<Integer, Integer> count = new HashMap<>();
        ListNode p = head;
        while (p != null) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode dump = new ListNode(Integer.MAX_VALUE);
        dump.next = head;
        p = dump;
        while (p != null) {
            ListNode unique = p.next;
            while (unique != null && count.get(unique.val) > 1) {
                unique = unique.next;
            }
            p.next = unique;
            p = p.next;
        }
        return dump.next;
    }
}