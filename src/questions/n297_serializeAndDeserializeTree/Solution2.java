package questions.n297_serializeAndDeserializeTree;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

// 后序遍历
public class Solution2 {
    private final String NULL = "#";
    private final String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SPLITTER);
            return;
        }
        serialize(root.left, sb);
        serialize(root.right, sb);
        sb.append(root.val).append(SPLITTER);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        for (String s : data.split(SPLITTER)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    public TreeNode deserialize(List<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String last = nodes.removeLast();
        if (NULL.equals(last)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }
}
