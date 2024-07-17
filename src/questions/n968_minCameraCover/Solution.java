package questions.n968_minCameraCover;

import utils.TreeNode;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量
 */
public class Solution {
    private int ans = 0;
    public int minCameraCover(TreeNode root) {
        check(root, false);
        return ans;
    }
    // 定义：检查当前节点的状态
    // -1 : 空节点
    // 0 : 未被监视
    // 1 : 已被监视
    // 2 : 安装了摄像头
    private int check(TreeNode root, boolean parent) {
        if (root == null) {
            return -1;
        }
        int left = check(root.left, true);
        int right = check(root.right, true);

        if (left == -1 && right == -1) {
            // 当前的叶子节点
            if (parent) {
                // 如果有父节点，就让父节点监视自己
                return 0;
            } else {
                // 否则安装摄像头监视自己
                ans++;
                return 2;
            }
        }

        // 子节点存在没有被监视
        if (left == 0 || right == 0) {
            ans++;
            return 2;
        }

        // 子节点存在摄像头
        if (left == 2 || right == 2) {
            return 1;
        }

        // 子节点都被监控了
        if (parent) {
            return 0;
        } else {
            ans++;
            return 2;
        }
    }
}
