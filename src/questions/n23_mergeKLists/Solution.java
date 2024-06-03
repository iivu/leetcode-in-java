package questions.n23_mergeKLists;

import utils.ListNode;
import utils.MinHeap;

import java.util.Comparator;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dump = new ListNode(-1);
        ListNode curr = dump;
        MinHeap<ListNode> minHeap = new MinHeap<>(lists.length, Comparator.comparingInt(node -> node.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode top = minHeap.peek();
            curr.next = top;
            curr = top;
            if (top.next == null) {
                minHeap.poll();
            } else {
                minHeap.replace(top.next);
            }
        }
        return dump.next;
    }
}