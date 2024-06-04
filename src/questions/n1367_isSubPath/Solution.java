package questions.n1367_isSubPath;

import utils.ListNode;
import utils.TreeNode;

/**
 * 给你一棵以 root 为根的二叉树和一个 head 为第一个节点的链表。
 * <p>
 * 如果在二叉树中，存在一条一直向下的路径，且每个点的数值恰好一一对应以 head 为首的链表中每个节点的值，那么请你返回 True ，否则返回 False 。
 * <p>
 * 一直向下的路径的意思是：从树中某个节点开始，一直连续向下的路径。
 */
public class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (check(head, root)) {
            return true;
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        if (head == null && root == null) {
            return true;
        }
        if (head == null || root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return check(head.next, root.left) || check(head.next, root.right);
    }
}
