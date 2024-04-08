import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || len < k) {
            return new int[]{-1};
        }
        int[] ans = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; ++i) {
            while (i >= k && !deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return ans;
    }
}
