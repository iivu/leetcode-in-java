package questions.n109_sortedListToBST;

import utils.ListNode;
import utils.TreeNode;

/**
 * 利用BST中序遍历为有序数组的特点
 */
public class Solution2 {
    private ListNode curr;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        int end = 0;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            end++;
        }
        curr = head;
        return traverse(0, end);
    }

    private TreeNode traverse(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode left = traverse(start, mid - 1);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = traverse(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
