package questions.n988_inserIntoMaxTree;

import utils.TreeNode;

/**
 * 最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。
 * <p>
 * 给你最大树的根节点 root 和一个整数 val 。
 * <p>
 * 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的：
 * <p>
 * 如果 a 为空，返回 null 。
 * 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。
 * root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。
 * root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。
 * 返回 root 。
 * 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。
 * <p>
 * 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。
 * <p>
 * 返回 Construct(b)
 */
public class Solution {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            // 如果val是最大的，那么原来的树就是val的左子树
            TreeNode temp = root;
            root = new TreeNode(val);
            root.left = temp;
            return root;
        } else {
            // 否则val一定在右子树里
            root.right = insertIntoMaxTree(root.right, val);
        }
        return root;
    }
}
