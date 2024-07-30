package questions.n510_inorderSuccessor;

/**
 * 给定一棵二叉搜索树和其中的一个节点 node ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * <p>
 * 一个节点 node 的中序后继是键值比 node.val 大所有的节点中键值最小的那个。
 * <p>
 * 你可以直接访问结点，但无法直接访问树。每个节点都会有其父节点的引用。节点 Node 定义如下：
 * <p>
 * class Node {
 * public int val;
 * public Node left;
 * public Node right;
 * public Node parent;
 * }
 */
public class Solution {
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    public Node inorderSuccessor(Node node) {
        Node p = node.right;
        while (p != null && p.left != null) {
            p = p.left;
        }
        if (p != null) {
            return p;
        }
        p = node;
        while (p.parent != null && p.parent.right == p) {
            p = p.parent;
        }
        return p.parent;
    }
}
