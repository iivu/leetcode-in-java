package questions.n234_isPalindromeList;

import utils.ListNode;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 */

// 递归解法
class Solution1 {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }

    private boolean traverse(ListNode right) {
        if (right == null) {
            return true;
        }
        boolean res = traverse(right.next);
        res = res && right.val == left.val;
        left = left.next;
        return res;
    }
}
