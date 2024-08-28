package questions.n449_codec;

import utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 */
public class Solution {
    public static class Codec {

        private final static String SPLITTER = ",";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            serialize(root, sb);
            return sb.toString();
        }

        public void serialize(TreeNode root, StringBuilder sb) {
            if (root == null) {
                return;
            }
            sb.append(root.val).append(SPLITTER);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) {
                return null;
            }
            String[] nodesArr = data.split(SPLITTER);
            List<Integer> inorder = new LinkedList<>();
            for (String n : nodesArr) {
                inorder.addLast(Integer.parseInt(n));
            }
            return deserialize(inorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        public TreeNode deserialize(List<Integer> nodes, int min, int max) {
            if (nodes.isEmpty()) {
                return null;
            }
            int rootVal = nodes.getFirst();
            if (rootVal < min || rootVal > max) {
                return null;
            }
            TreeNode root = new TreeNode(nodes.removeFirst());
            root.left = deserialize(nodes, min, rootVal);
            root.right = deserialize(nodes, rootVal, max);
            return root;
        }
    }
}
