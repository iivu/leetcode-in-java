package questions.n1094_carPoolong;

import utils.Difference;

/**
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips , trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * 1 <= trips.length <= 1000
 */
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Difference diff = new Difference(new int[1001]);
        for (int[] trip : trips) {
            diff.increment(trip[1], trip[2] - 1, trip[0]);
        }

        int[] res = diff.getArray();
        for (int count : res) {
            if (count > capacity) {
                return false;
            }
        }
        return true;
    }
}