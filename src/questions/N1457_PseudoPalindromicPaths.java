package questions;

import utils.TreeNode;

class SolutionN1457_1 {
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

class SolutionN1457_2 {
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