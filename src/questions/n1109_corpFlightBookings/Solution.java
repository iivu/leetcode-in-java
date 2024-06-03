package questions.n1109_corpFlightBookings;

import utils.Difference;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 * <p>
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 * <p>
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Difference diff = new Difference(new int[n]);
        for (int[] booking : bookings) {
            diff.increment(booking[0] - 1, booking[1] - 1, booking[2]);
        }
        return diff.getArray();
    }
}