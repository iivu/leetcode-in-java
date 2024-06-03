package questions.n78_subsets;

import java.util.LinkedList;
import java.util.List;

// 「球」视角，「球」可以穷举自己可以在什么位置
public class Solution2 {
    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums);
        return ans;
    }

    private void backtrace(int[] nums) {

    }
}
