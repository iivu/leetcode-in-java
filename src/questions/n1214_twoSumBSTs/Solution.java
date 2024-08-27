package questions.n1214_twoSumBSTs;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两棵二叉搜索树的根节点 root1 和 root2 ，请你从两棵树中各找出一个节点，使得这两个节点的值之和等于目标值 Target。
 * <p>
 * 如果可以找到返回 True，否则返回 False。
 */
public class Solution {

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        traverse(root1, list1);
        traverse(root2, list2);
        int i = 0, j = list2.size() - 1;
        while (i < list1.size() && j >= 0) {
            int sum = list1.get(i) + list2.get(j);
            if (sum == target) {
                return true;
            }
            if (sum < target) {
                i++;
            }else {
                j--;
            }
        }
        return false;
    }

    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}
