package questions;

/**
 * 给你一个整数n，请你找出并返回第n个丑数。
 * <p>
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * 注意：1通常被视为丑数。
 */
class SolutionN264 {
    public int nthUglyNumber(int n) {
        // n是丑数，那么：2*n,3*n,5*n 也会是丑数
        int[] uglies = new int[n + 1];
        int p = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        int value2 = 1, value3 = 1, value5 = 1;
        while (p <= n) {
            int min = Math.min(Math.min(value2, value3), value5);
            uglies[p] = min;
            if (min == value2) {
                value2 = uglies[p2] * 2;
                p2++;
            }
            if (min == value3) {
                value3 = uglies[p3] * 3;
                p3++;
            }
            if (min == value5) {
                value5 = uglies[p5] * 5;
                p5++;
            }
            p++;
        }
        return uglies[n];
    }
}