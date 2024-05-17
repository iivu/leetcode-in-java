package questions;

class SolutionN238 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        if (len == 2) {
            ans[0] = nums[1];
            ans[1] = nums[0];
            return ans;
        }
        int[] prefix = new int[len + 1];
        int[] suffix = new int[len + 1];
        prefix[0] = suffix[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
            suffix[i] = suffix[i - 1] * nums[len - i];
        }
        for(int i = 0 ;i <len;i++) {
            ans[i] = prefix[i] * suffix[len - i - 1];
        }
        return ans;
    }
}