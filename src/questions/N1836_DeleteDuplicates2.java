package questions;

import utils.ListNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionN1836 {
    public ListNode deleteDuplicates(ListNode head) {
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