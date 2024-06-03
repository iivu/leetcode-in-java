package questions.n341_nestInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个嵌套的整数列表 nestedList 。
 * 每个元素要么是一个整数，
 * 要么是一个列表；该列表的元素也可能是整数或者是其他列表。请你实现一个迭代器将其扁平化，使之能够遍历这个列表中的所有整数。
 * <p>
 * 实现扁平迭代器类 NestedIterator ：
 * <p>
 * NestedIterator(List nestedList) 用嵌套列表 nestedList 初始化迭代器。
 * int next() 返回嵌套列表的下一个整数。
 * boolean hasNext() 如果仍然存在待迭代的整数，返回 true ；否则，返回 false
 */
class Solution {
    public static class NestedInteger {
        private Integer val = null;
        private List<NestedInteger> list = null;

        public NestedInteger(Integer val) {
            this.val = val;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
        }

        public boolean isInteger() {
            return val != null;
        }

        public Integer getInteger() {
            return this.val;
        }

        public List<NestedInteger> getList() {
            return this.list;
        }
    }

    public static class NestedIterator1 implements Iterator<Integer> {
        private final List<NestedInteger> internal;

        public NestedIterator1(List<NestedInteger> nestedList) {
            this.internal = new LinkedList<>(nestedList);
        }

        @Override
        public Integer next() {
            return internal.removeFirst().getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!internal.isEmpty() && !internal.getFirst().isInteger()) {
                List<NestedInteger> first = internal.removeFirst().getList();
                for (int i = first.size() - 1; i >= 0; i--) {
                    internal.addFirst(first.get(i));
                }
            }
            return !internal.isEmpty();
        }
    }

    // 多叉树解法
    // 因为预先打平了数组，不符合惰性求值
    public static class NestedIterator2 implements Iterator<Integer> {
        private final List<Integer> internal;
        private final Iterator<Integer> it;

        public NestedIterator2(List<NestedInteger> nestedList) {
            internal = new LinkedList<>();
            for (NestedInteger n : nestedList) {
                traverse(n);
            }
            it = internal.iterator();
        }

        @Override
        public Integer next() {
            return it.next();
        }

        @Override
        public boolean hasNext() {
            return it.hasNext();
        }

        private void traverse(NestedInteger node) {
            if (node.isInteger()) {
                internal.add(node.getInteger());
                return;
            }
            for (NestedInteger n : node.getList()) {
                traverse(n);
            }
        }
    }
}