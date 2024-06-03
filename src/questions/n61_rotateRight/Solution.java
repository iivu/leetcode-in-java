package questions.n61_rotateRight;

import utils.ListNode;

/**
 * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int nodeCount = 1;
        ListNode curr = head;
        while (curr.next != null) {
            nodeCount++;
            curr = curr.next;
        }
        // 实际步数
        int step = k % nodeCount;
        if (step == 0) {
            return head;
        }
        step = nodeCount - step;

        // 将链表连成环
        curr.next = head;

        while (step != 0) {
            step--;
            curr = curr.next;
        }
        ListNode ans = curr.next;
        curr.next = null;
        return ans;
    }
}