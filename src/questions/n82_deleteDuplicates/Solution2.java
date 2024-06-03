package questions.n82_deleteDuplicates;

import utils.ListNode;

// 递归解法
public class Solution2 {
    // 递归函数定义：给我一个链表头head，返回去重后的链表头
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while (head.next != null && head.val == head.next.val) {
            head = head.next;
        }
        return deleteDuplicates(head.next);
    }
}