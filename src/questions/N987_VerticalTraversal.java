package questions;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。
 * <p>
 * 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。
 * <p>
 * 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。
 * <p>
 * 返回二叉树的 垂序遍历 序列。
 */
class SolutionN987 {
    private static class Node {
        public int row;
        public int col;
        public TreeNode treeNode;

        public Node(int row, int col, TreeNode treeNode) {
            this.row = row;
            this.col = col;
            this.treeNode = treeNode;
        }
    }

    private final List<Node> nodes = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        traverse(root, 0, 0);
        nodes.sort((Node a, Node b) -> {
            if (a.col == b.col && a.row == b.row) {
                return a.treeNode.val - b.treeNode.val;
            }
            if (a.col == b.col) {
                return a.row - b.row;
            }
            return a.col - b.col;
        });
        List<List<Integer>> ans = new LinkedList<>();
        int currCol = Integer.MIN_VALUE;
        for (Node node : nodes) {
            if (node.col != currCol) {
                currCol = node.col;
                ans.addLast(new ArrayList<>());
            }
            ans.getLast().add(node.treeNode.val);
        }
        return ans;
    }

    private void traverse(TreeNode root, int row, int col) {
        if (root == null) {
            return;
        }
        nodes.add(new Node(row, col, root));
        traverse(root.left, row + 1, col - 1);
        traverse(root.right, row + 1, col + 1);
    }
}