package questions.lcr173_takeAttendance;

/**
 * 某班级 n 位同学的学号为 0 ~ n-1。点名结果记录于升序数组 records。假定仅有一位同学缺席，请返回他的学号。
 */
class Solution
{
    public int takeAttendance(int[] records) {
        int l = 0, r = records.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (records[mid] == mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}