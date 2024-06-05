package questions.n426_treeToDoublyList;

public class Solution {

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    public Node treeToDoublyList(Node root) {
        return build(root);
    }

    // 定义：给定一个二叉搜索树的跟节点，返回构成成循环链表后的链表头
    private Node build(Node root) {
        if (root == null) {
            return null;
        }
        Node leftHead = build(root.left);
        Node rightHead = build(root.right);
        Node leftTail, rightTail;
        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            leftTail = leftHead = root;
        }
        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightHead = rightTail = root;
        }
        leftHead.left = rightTail;
        rightTail.right = leftHead;
        return leftHead;
    }
}
