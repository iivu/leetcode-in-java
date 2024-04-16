package questions;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 */

// BFS
class SolutionN752_1 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(List.of(deadends));
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        q1.add("0000");
        q2.add(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String curr : q1) {
                if (deads.contains(curr)) {
                    continue;
                }
                if (q2.contains(curr)) {
                    return ans;
                }
                visited.add(curr);
                for (int i = 0; i < 4; i++) {
                    String up = this.up(curr, i);
                    String down = this.down(curr, i);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }

            }
            ans++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    private String up(String lock, int index) {
        char[] chs = lock.toCharArray();
        if (chs[index] == '9') {
            chs[index] = '0';
        } else {
            chs[index]++;
        }
        return new String(chs);
    }

    private String down(String lock, int index) {
        char[] chs = lock.toCharArray();
        if (chs[index] == '0') {
            chs[index] = '9';
        } else {
            chs[index]--;
        }
        return new String(chs);
    }
}

// BFS，双向优化
class SolutionN752_2 {
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(List.of(deadends));
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int ans = 0;
        q1.add("0000");
        q2.add(target);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String curr : q1) {
                if (deads.contains(curr)) {
                    continue;
                }
                if (q2.contains(curr)) {
                    return ans;
                }
                visited.add(curr);
                for (int i = 0; i < 4; i++) {
                    String up = this.up(curr, i);
                    String down = this.down(curr, i);
                    if (!visited.contains(up)) {
                        temp.add(up);
                    }
                    if (!visited.contains(down)) {
                        temp.add(down);
                    }
                }

            }
            ans++;
            q1 = q2;
            q2 = temp;
        }
        return -1;
    }

    private String up(String lock, int index) {
        char[] chs = lock.toCharArray();
        if (chs[index] == '9') {
            chs[index] = '0';
        } else {
            chs[index]++;
        }
        return new String(chs);
    }

    private String down(String lock, int index) {
        char[] chs = lock.toCharArray();
        if (chs[index] == '0') {
            chs[index] = '9';
        } else {
            chs[index]--;
        }
        return new String(chs);
    }
}