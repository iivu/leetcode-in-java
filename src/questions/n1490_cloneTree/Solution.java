package questions.n1490_cloneTree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val,ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Node cloneRoot = new Node(root.val);
        for (Node c : root.children) {
            cloneRoot.children.add(cloneTree(c));
        }
        return cloneRoot;
    }
}
