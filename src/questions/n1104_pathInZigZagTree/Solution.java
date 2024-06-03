package questions.n1104_pathInZigZagTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 */
public class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new LinkedList<>();
        while (true) {
            ans.addFirst(label);
            if (label == 1) {
                break;
            }
            label = getParent(label);
        }
        return ans;
    }

    // 将树每个节点用二进制表示，会发现：
    // 子节点移除最后一位，除最高位以外，其余位取反后，刚好等于父节点
    private int getParent(int num) {
        num = num >> 1;
        String bitString = Integer.toBinaryString(num);
        return ((1 << (bitString.length() - 1)) - 1) ^ num;
    }
}
