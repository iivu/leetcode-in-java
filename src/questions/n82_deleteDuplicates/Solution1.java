package questions.n82_deleteDuplicates;

import utils.ListNode;

/**
 * 给定一个已排序的链表的头head，删除原始链表中所有重复数字的节点，只留下不同的数字。返回已排序的链表。
 */

// 遍历解法
class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dump = new ListNode(Integer.MAX_VALUE);
        ListNode p1 = dump;
        ListNode p2 = head;
        while (p2 != null) {
            if (p2.next != null && p2.val == p2.next.val) {
                //  不断移除重复元素
                while (p2.next != null && p2.next.val == p2.val) {
                    p2 = p2.next;
                }
                // 到了最后一个重复元素，再移动一位移除掉最后一个重复元素
                p2 = p2.next;
                if (p2 == null) {
                    p1.next = null;
                }
            } else {
                p1.next = p2;
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return dump.next;
    }
}