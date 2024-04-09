package utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        this.val = arr[0];
        ListNode current = this;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        ListNode current = this;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.val);
            sb.append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
