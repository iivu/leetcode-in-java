package questions.n331_isValidSerilization;

public class Solution2 {
    // 利用节点和边的关系：
    // 一个非空节点会消耗1条边，产生2条边
    // 一个合法的二叉数，总边数为0
    public boolean isValidSerialization(String preorder) {
        // 一开始有一条虚拟边指向root
        int edge = 1;
        for (String s : preorder.split(",")) {
            if ("#".equals(s)) {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
            } else {
                edge -= 1;
                if (edge < 0) {
                    return false;
                }
                edge += 2;
            }
        }
        return edge == 0;
    }
}
