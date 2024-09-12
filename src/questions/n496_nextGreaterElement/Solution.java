package questions.n496_nextGreaterElement;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        final Map<Integer, Integer> biggerMap = new HashMap<>();
        // 单调栈
        Deque<Integer> stack = new LinkedList<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            biggerMap.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = biggerMap.get(nums1[i]);
        }
        return ans;
    }
}
