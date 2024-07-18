package questions.n117_connect;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL 。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL 。
 */
public class Solution {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        List<Node> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int next = i + 1;
                Node curr = queue.removeFirst();
                curr.next = next >= size ? null : queue.getFirst();
                if (curr.left != null) queue.addLast(curr.left);
                if (curr.right != null) queue.addLast(curr.right);
            }
        }
        return root;
    }
}
