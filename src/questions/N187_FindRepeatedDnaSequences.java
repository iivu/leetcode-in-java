package questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionN187 {
    // 4进制
    private final int R = 4;
    // 10位数
    private final int bitCount = 10;

    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> memo = new HashSet<>();
        Set<String> res = new HashSet<>();
        int l = 0, r = 0;
        int hashVal = 0;
        while (r < s.length()) {
            char ch = s.charAt(r++);
            hashVal = addLow(ch, hashVal);
            if (r - l == bitCount) {
                if (memo.contains(hashVal)) {
                    res.add(s.substring(l, r));
                } else {
                    memo.add(hashVal);
                }
                char out = s.charAt(l++);
                hashVal = removeHigh(out, hashVal);
            }
        }
        return new ArrayList<>(res);
    }

    public int addLow(char ch, int target) {
        return target * R + mapChar(ch);
    }

    public int removeHigh(char ch, int target) {
        return target - mapChar(ch) * (int) Math.pow(R, bitCount - 1);
    }

    public int mapChar(char ch) {
        return switch (ch) {
            case 'A' -> 0;
            case 'G' -> 1;
            case 'C' -> 2;
            case 'T' -> 3;
            default -> -1;
        };
    }
}