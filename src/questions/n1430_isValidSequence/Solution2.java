package questions.n1430_isValidSequence;

import utils.TreeNode;

public class Solution2 {

    public boolean isValidSequence(TreeNode root, int[] arr) {
        return check(root, arr, 0);
    }

    // 定义：输入一棵树root，判断是否存在一条从根到叶子节点的路径的值为 arr[i..]
    private boolean check(TreeNode root, int[] arr, int i) {
        if (root == null || i >= arr.length || root.val != arr[i]) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == arr[i] && i == arr.length - 1;
        }
        return check(root.left, arr, i + 1) || check(root.right, arr, i + 1);
    }
}
