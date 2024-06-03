package questions.n1457_pseudoPalindromicPaths;

import utils.TreeNode;

public class Solution1 {
    private final int[] path = new int[10];
    private int ans = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        traverse(root);
        return ans;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        path[root.val] += 1;
        if (root.left == null && root.right == null) {
            // 到达叶子子节点
            int oddCount = 0;
            for (int v : path) {
                if (v % 2 == 1) {
                    oddCount += 1;
                }
            }
            if (oddCount <= 1) {
                ans += 1;
            }
            path[root.val] -= 1;
            return;
        }
        traverse(root.left);
        traverse(root.right);
        path[root.val] -= 1;
    }
}
