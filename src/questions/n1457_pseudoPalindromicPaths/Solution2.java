package questions.n1457_pseudoPalindromicPaths;

import utils.TreeNode;

public class Solution2 {
    private int path = 0;
    private int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return ans;
    }

    // 使用位运算加速
    // a ^ a = 0; 0 ^ a = a
    // a & (a - 1): 消除a二进制表示的最后一个1
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        path = path ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            // 到达叶子子节点
            if ((path & (path - 1)) == 0) {
                ans += 1;
            }
            path = path ^ (1 << root.val);
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path = path ^ (1 << root.val);
    }
}
