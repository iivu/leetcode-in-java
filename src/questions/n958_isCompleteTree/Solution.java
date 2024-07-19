package questions.n958_isCompleteTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你判断这棵树是否是一棵 完全二叉树 。
 * <p>
 * 在一棵 完全二叉树 中，除了最后一层外，所有层都被完全填满，并且最后一层中的所有节点都尽可能靠左。最后一层（第 h 层）中可以包含 1 到 2h 个节点。
 */
public class Solution {

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isEnd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    isEnd = true;
                } else {
                    if (isEnd) {
                        return false;
                    }
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
            }
        }
        return true;
    }
}
