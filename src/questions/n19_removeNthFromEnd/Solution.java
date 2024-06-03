package questions.n19_removeNthFromEnd;

import utils.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 *
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
class Solution {
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

