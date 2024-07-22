package questions.n752_openLock;

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
public class Solution1 {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr == null) {
                    continue;
                }
                if (visited.contains(curr)) {
                    continue;
                } else {
                    visited.add(curr);
                }
                if (curr.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(curr, j);
                    String down = down(curr, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                    }
                    if (!visited.contains(down)) {
                        queue.offer(down);
                    }
                }
            }
            step++;
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
