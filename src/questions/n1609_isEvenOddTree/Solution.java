package questions.n1609_isEvenOddTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 */
public class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOdd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                if (isOdd && curr.val % 2 != 0) {
                    return false;
                }
                if (!isOdd && curr.val % 2 == 0) {
                    return false;
                }
                if (isOdd && i < size - 1 && queue.peek() != null && curr.val <= queue.peek().val ) {
                    return false;
                }
                if (!isOdd && i < size - 1 && queue.peek() != null && curr.val >= queue.peek().val ) {
                    return false;
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            isOdd = !isOdd;
        }
        return true;
    }
}
