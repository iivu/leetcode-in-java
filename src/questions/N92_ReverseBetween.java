package questions;

import utils.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right。
 * 请你反转从位置 left 到位置 right 的链表节点，返回反转后的链表。
 */
class SolutionN92 {
    private ListNode after;
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        }
        head.next = reverseBetween(head.next,left - 1, right - 1);
        return head;
    }

    private ListNode reverseN(ListNode head , int n) {
        if (n == 1) {
            after = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = after;
        return last;
    }
}