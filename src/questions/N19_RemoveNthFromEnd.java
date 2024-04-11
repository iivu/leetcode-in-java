package questions;

import utils.ListNode;

class SolutionN19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode prev = getNodeFromEnd(head, n + 1);
        ListNode target = prev.next;
        prev.next = target.next;
        target.next = null;
        return dump.next;
    }

    private ListNode getNodeFromEnd(ListNode head, int end) {
        ListNode p1 = head;
        // p1 先走 end 步
        for (int i = 0; i < end; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1,p2再同时走，当p1到达末尾(null)是，p2到达倒数第end个元素上
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

