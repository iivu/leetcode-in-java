package questions.n536_str2tree;

import utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 你需要用一个包括括号和整数的字符串构建一棵二叉树。
 * <p>
 * 输入的字符串代表一棵二叉树。它包括整数和随后的 0 、1 或 2 对括号。整数代表根的值，一对括号内表示同样结构的子树。
 * <p>
 * 若存在子结点，则从左子结点开始构建。
 */
public class Solution {
    public TreeNode str2tree(String s) {
        if (s.isEmpty()) {
            return null;
        }
        int len = s.length();
        int p = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        while (p < len) {
            char ch = s.charAt(p);
            if (ch == '(') {
                p++;
                continue;
            }
            if (ch == ')') {
                deque.removeFirst();
                p++;
                continue;
            }
            int j = p;
            int num = 0;
            int sign = s.charAt(j) == '-' ? -1 : 1;
            if (s.charAt(j) == '-') {
                j++;
            }
            while (j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9') {
                num = num * 10 + (s.charAt(j) - '0');
                j++;
            }
            num *= sign;
            p = j;
            TreeNode node = new TreeNode(num);
            if (!deque.isEmpty()) {
                TreeNode parent = deque.getFirst();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
            deque.addFirst(node);
        }
        return deque.getFirst();
    }
}
