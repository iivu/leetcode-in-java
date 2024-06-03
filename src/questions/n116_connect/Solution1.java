package questions.n116_connect;

public class Solution1 {

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

    // 如果将每层节点两两一组抽象得看，就变成了一个三叉树问题
    public Node connect(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node l, Node r) {
        if (l == null || r == null) {
            return;
        }
        l.next = r;
        traverse(l.left, l.right);
        traverse(l.right, r.left);
        traverse(r.left, r.right);
    }
}
