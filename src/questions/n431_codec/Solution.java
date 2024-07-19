package questions.n431_codec;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class Codec {
        private static class Pair {
            public TreeNode bNode;
            public Node node;

            public Pair(TreeNode bNode, Node node) {
                this.bNode = bNode;
                this.node = node;
            }
        }

        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Pair> q = new LinkedList<>();
            TreeNode bRoot = new TreeNode(root.val);
            q.offer(new Pair(bRoot, root));
            while (!q.isEmpty()) {
                Pair curr = q.poll();
                TreeNode currBNode = curr.bNode;
                Node currNode = curr.node;
                TreeNode dump = new TreeNode(-1), p = dump;
                for (Node c : currNode.children) {
                    TreeNode newBNode = new TreeNode(c.val);
                    q.offer(new Pair(newBNode, c));
                    p.right = newBNode;
                    p = p.right;
                }
                currBNode.left = dump.right;
            }
            return bRoot;
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            Queue<Pair> q = new LinkedList<>();
            Node nRoot = new Node(root.val);
            q.offer(new Pair(root, nRoot));
            while (!q.isEmpty()) {
                Pair curr = q.poll();
                TreeNode currBNode = curr.bNode;
                Node currNode = curr.node;
                List<Node> children = new ArrayList<>();
                for (TreeNode p = currBNode.left; p != null; p = p.right) {
                    Node newNode = new Node(p.val);
                    children.add(newNode);
                    q.add(new Pair(p, newNode));
                }
                currNode.children = children;
            }
            return nRoot;
        }
    }
}
