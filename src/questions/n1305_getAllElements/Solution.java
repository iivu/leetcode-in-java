package questions.n1305_getAllElements;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 */
public class Solution {

    public static class BSTIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            pushLeft(root);
        }

        public int next() {
            TreeNode curr = stack.pop();
            pushLeft(curr.right);
            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public int peek() {
            if (stack.isEmpty()) throw new RuntimeException("Stack is empty");
            return stack.peek().val;
        }

        private void pushLeft(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        BSTIterator itor1 = new BSTIterator(root1);
        BSTIterator itor2 = new BSTIterator(root2);
        List<Integer> ans = new ArrayList<>();

        while (itor1.hasNext() && itor2.hasNext()) {
            if (itor1.peek() > itor2.peek()) {
                ans.add(itor2.next());
            } else {
                ans.add(itor1.next());
            }
        }

        while (itor1.hasNext()) {
            ans.add(itor1.next());
        }

        while (itor2.hasNext()) {
            ans.add(itor2.next());
        }

        return ans;
    }
}
