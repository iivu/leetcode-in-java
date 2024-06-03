package questions.n297_serializeAndDeserializeTree;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// 层序遍历
public class Solution3 {
    private final String NULL = "#";
    private final String SPLITTER = ",";

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (curr == null) {
                    sb.append(NULL).append(SPLITTER);
                    continue;
                }
                sb.append(curr.val).append(SPLITTER);
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        String[] nodes = data.split(SPLITTER);
        int index = 1;
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                String l = nodes[index++];
                String r = nodes[index++];
                if (!NULL.equals(l)) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(l));
                    curr.left = leftNode;
                    queue.offer(leftNode);
                }
                if (!NULL.equals(r)) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(r));
                    curr.right = rightNode;
                    queue.offer(rightNode);
                }
            }
        }
        return root;
    }
}
