package questions.lcr172_countTarget;

/**
 * 某班级考试成绩按非严格递增顺序记录于整数数组 scores，请返回目标成绩 target 的出现次数
 */
class Solution {
    public int countTarget(int[] scores, int target) {
        int ans = 0;
        int l = 0, r = scores.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (scores[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        for (int i = l; i < scores.length; i++) {
            if (scores[i] == target) {
                ans++;
            } else {
                break;
            }
        }
        return ans;
    }
}