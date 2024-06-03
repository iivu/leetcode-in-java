package questions.n116_connect;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    // BFS
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i + 1 >= size) {
                    node.next = null;
                } else {
                    node.next = queue.peek();
                }
            }
        }
        return root;
    }
}
