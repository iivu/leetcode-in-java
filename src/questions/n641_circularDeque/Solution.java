package questions.n641_circularDeque;

public class Solution {
   public static class MyCircularDeque {
        private int size;
        private final int[] data;
        private int first, last;

        public MyCircularDeque(int k) {
            size = first = last = 0;
            data = new int[k];
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            if (first == 0) {
                first = data.length - 1;
            } else {
                first--;
            }
            data[first] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            data[last] = value;
            last++;
            size++;
            if (last == data.length) {
                last = 0;
            }
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            first++;
            size--;
            if (first == data.length) {
                first = 0;
            }
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            if(last == 0) {
                last = data.length - 1;
            } else {
                last--;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) {
                return -1;
            }
            return data[first];
        }

        public int getRear() {
            if (isEmpty()) {
                return -1;
            }
            if (last == 0) {
                return data[data.length - 1];
            } else {
                return data[last - 1];
            }
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == data.length;
        }
    }
}
