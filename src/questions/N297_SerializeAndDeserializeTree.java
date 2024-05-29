package questions;

import utils.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 */

// 前序遍历
class SolutionN297_1 {
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
        sb.append(root.val).append(SPLITTER);
        serialize(root.left, sb);
        serialize(root.right, sb);
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
        String first = nodes.removeFirst();
        if (NULL.equals(first)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}

// 后序遍历
class SolutionN297_2 {
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

// 层序遍历
class SolutionN297_3 {
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