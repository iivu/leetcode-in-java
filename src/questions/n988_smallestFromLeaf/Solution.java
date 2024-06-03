package questions.n988_smallestFromLeaf;

import utils.TreeNode;

/**
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
 * <p>
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 */
class Solution {
    private final StringBuilder sb = new StringBuilder();
    private String ans = null;

    public String smallestFromLeaf(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append((char) ('a' + root.val));
        if (root.left == null && root.right == null) {
            sb.reverse();
            String curr = sb.toString();
            if (ans == null || ans.compareTo(curr) > 0) {
                ans = curr;
            }
            sb.reverse();
            sb.deleteCharAt(sb.length() - 1);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        sb.deleteCharAt(sb.length() - 1);
    }
}