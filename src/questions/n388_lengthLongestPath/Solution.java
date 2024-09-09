package questions.n388_lengthLongestPath;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int lengthLongestPath(String input) {
        Deque<String> stack = new LinkedList<>();
        int ans = 0;
        for(String part : input.split("/n")) {
            int level = part.lastIndexOf("/t") + 1;
            while (!stack.isEmpty() && stack.size() > level) {
                stack.removeLast();
            }
            stack.addLast(part.substring(level));
            if (part.contains(".")) {
                int length = stack.stream().mapToInt(String::length).sum();
                // 加上分割符
                length += stack.size() - 1;
                ans = Math.max(ans, length);
            }
        }
        return ans;
    }
}
