package questions.n752_openLock;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// BFS，双向优化
public class Solution2 {
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
