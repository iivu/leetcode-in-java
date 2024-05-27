package questions;

class SolutionN162 {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else if (nums[mid] < nums[mid] + 1) {
                l = mid + 1;
            }
        }
        return l;
    }
}