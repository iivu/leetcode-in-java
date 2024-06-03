package questions.n204_countPrimes;

import java.util.Arrays;

/**
 * 给定整数n，返回所有小于非负整数n的质数的数量。
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n];
        Arrays.fill(isPrimes, true);
        // 质数筛选法，如果一个数n是质数，那2n,3n,4n,5n,...,n*n都不会是质数了
        for (int i = 2; i * i < n; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrimes[j] = false;
                }
            }
        }
        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                ans++;
            }
        }
        return ans;
    }
}