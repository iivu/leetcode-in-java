package questions;

import java.util.LinkedList;
import java.util.List;

class SolutionN658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int leftBound = searchLeftBound(arr, x);
        List<Integer> ans = new LinkedList<>();
        int l = leftBound - 1, r = leftBound;
        while (r - l - 1 < k) {
            if (l == -1) {
                ans.addLast(arr[r++]);
            } else if (r == arr.length) {
                ans.addFirst(arr[l--]);
            } else if (Math.abs(arr[l] - x) > Math.abs(arr[r] - x)) {
                ans.addLast(arr[r++]);
            } else {
                ans.addFirst(arr[l--]);
            }
        }
        return ans;
    }

    private int searchLeftBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}