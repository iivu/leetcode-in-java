package questions.n895_freqStack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public static class FreqStack {

        private int maxFreq = 0;
        private final Map<Integer, Integer> val2Freq = new HashMap<>();
        private final Map<Integer, Deque<Integer>> freq2Vals = new HashMap<>();

        public FreqStack() {

        }

        public void push(int val) {
            if (maxFreq == 0) {
                // 当前还没有任何元素
                maxFreq++;
                val2Freq.put(val, 1);
                freq2Vals.put(1, new LinkedList<>());
                freq2Vals.get(1).addLast(val);
                return;
            }
            if (!val2Freq.containsKey(val)) {
                // 当前元素第一次出现
                freq2Vals.get(1).addLast(val);
                val2Freq.put(val, 1);
                return;
            }
            int freq = val2Freq.get(val);
            int newFreq = freq + 1;
            if (newFreq > maxFreq) {
                maxFreq = newFreq;
            }
            val2Freq.put(val, newFreq);
            if (!freq2Vals.containsKey(newFreq)) {
                freq2Vals.put(newFreq,new LinkedList<>());
            }
            freq2Vals.get(newFreq).addLast(val);
        }

        public int pop() {
            while (freq2Vals.containsKey(maxFreq) && freq2Vals.get(maxFreq).isEmpty()) {
                maxFreq--;
            }
            if (!freq2Vals.containsKey(maxFreq)) {
                throw new RuntimeException();
            }
            int target = freq2Vals.get(maxFreq).removeLast();
            val2Freq.put(target, val2Freq.get(target) - 1);
            return target;
        }
    }
}
