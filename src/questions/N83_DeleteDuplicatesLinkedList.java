package questions;

import utils.ListNode;

class SolutionN83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }
}