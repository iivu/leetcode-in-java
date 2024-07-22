package questions.n582_killProcess;

import java.util.*;

/**
 * 系统中存在 n 个进程，形成一个有根树结构。给你两个整数数组 pid 和 ppid ，其中 pid[i] 是第 i 个进程的 ID ，ppid[i] 是第 i 个进程的父进程 ID 。
 * <p>
 * 每一个进程只有 一个父进程 ，但是可能会有 一个或者多个子进程 。只有一个进程的 ppid[i] = 0 ，意味着这个进程 没有父进程 。
 * <p>
 * 当一个进程 被杀掉 的时候，它所有的子进程和后代进程都要被杀掉。
 * <p>
 * 给你一个整数kill表示要杀掉进程的ID，返回被杀掉的进程的 ID 列表。可以按 任意顺序 返回答案。
 */
public class Solution {
    private final Map<Integer, List<Integer>> tree = new HashMap<>();
    private final List<Integer> ans = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        buildTree(pid, ppid);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans.add(curr);
            List<Integer> children = tree.get(curr);
            if (children != null) {
                queue.addAll(children);
            }
        }
        return ans;
    }

    private void buildTree(List<Integer> pid, List<Integer> ppid) {
        for (int i = 0; i < pid.size(); i++) {
            int c = pid.get(i);
            int p = ppid.get(i);
            if (!tree.containsKey(p)) {
                tree.put(p, new ArrayList<>());
            }
            tree.get(p).add(c);
        }
    }
}
