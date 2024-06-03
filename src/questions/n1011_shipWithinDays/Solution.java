package questions.n1011_shipWithinDays;

/**
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 */
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = Integer.MIN_VALUE;
        int maxCapacity = 0;
        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        int l = minCapacity, r = maxCapacity;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int d = usedDays(mid, weights);
            if (d > days) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private int usedDays(int capacity, int[] weights) {
        int days = 1;
        int totalWeights = 0;
        for (int weight : weights) {
            if (totalWeights + weight <= capacity) {
                totalWeights += weight;
            } else {
                totalWeights = weight;
                days += 1;
            }
        }
        return days;
    }
}