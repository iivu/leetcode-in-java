package questions;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 */
class SolutionN875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = Integer.MIN_VALUE;
        int minSpeed = 1;
        for (int pile : piles) {
            maxSpeed = Math.max(pile, maxSpeed);
        }
        int l = minSpeed, r = maxSpeed;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long time = usedTime(mid, piles);
            if (time == h) {
                r = mid - 1;
            } else if (time > h) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private long usedTime(int speed, int[] piles) {
        long res = 0;
        for (int pile : piles) {
            res += (pile + speed - 1) / speed;
        }
        return res;
    }
}