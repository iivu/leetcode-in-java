package questions;

import utils.MinHeap;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * <p>
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * <p>
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 */
class SolutionN313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] superUglies = new int[n + 1];
        int p = 1;
        int[] ps = new int[primes.length];
        int[] values = new int[primes.length];
        MinHeap<Integer> minHeap = new MinHeap<>((Integer[]) values, Comparator.comparingInt(v->v));
        Arrays.fill(ps, 1);
        Arrays.fill(values, 1);
        while (p <= n) {
            p++;
        }
        return superUglies[n];
    }
}