package questions.n25_reverseKGroup;

import utils.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseKGroup(b, k);
        return newHead;
    }

    // 反转 [a,b) 间的节点
    // 反转一个链表可以看作是反转[head, null) -> reverse(head, null)
    private ListNode reverse(ListNode a, ListNode b) {
        if (a == null) {
            return null;
        }
        ListNode prev = null, curr = a, next;
        while (curr != b) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}