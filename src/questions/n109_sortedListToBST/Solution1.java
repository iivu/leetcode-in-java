package questions.n109_sortedListToBST;

import utils.ListNode;
import utils.TreeNode;

/**
 * 给定一个单链表的头节点  head ，其中的元素 按升序排序 ，将其转换为
 * 平衡二叉搜索树。
 */
public class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if(head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode f = head, s = head, p = null;
        while (f != null && f.next != null) {
            f = f.next.next;
            p = s;
            s = s.next;
        }
        p.next = null;
        // 快慢指针，这时s来到了链表中点
        TreeNode root = new TreeNode(s.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(s.next);
        return root;
    }
}
