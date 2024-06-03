package questions.n652_findDuplicateSubtree;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private final Map<String,Integer> memo = new HashMap<>();
    private final List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return ans;
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        String my = right + "," + left + "," + root.val;
        if (!memo.containsKey(my)) {
            memo.put(my, 1);
        } else {
            memo.put(my, memo.get(my) + 1);
        }
        if (memo.get(my) == 2) {
            ans.add(root);
        }
        return my;
    }
}