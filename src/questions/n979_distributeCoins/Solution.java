package questions.n979_distributeCoins;

import utils.TreeNode;

/**
 * 给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。
 * <p>
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。
 * <p>
 * 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。
 */
public class Solution {
    private int ans = 0;

    public int distributeCoins(TreeNode root) {
        getRemain(root);
        return ans;
    }

    // 定义：返回每个子节点都有一个硬币后多出来硬币数
    // 大于0，说明有多余，小于0说明不够，等于0说明刚好分配完
    private int getRemain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getRemain(root.left);
        int right = getRemain(root.right);
        ans += Math.abs(left) + Math.abs(right) + root.val - 1;
        return (root.val - 1) + left + right;
    }
}
