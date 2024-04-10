package utils;

import java.util.NoSuchElementException;

public class DoublyLinkedList<E> {

    private static class Node<E> {
        E val;
        Node<E> next, prev;

        Node(E val) {
            this.val = val;
        }
    }

    private final Node<E> head;
    private final Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public DoublyLinkedList(E val) {
        this();
        addFirst(val);
    }

    public DoublyLinkedList(E[] arr) {
        this();
        if (arr.length == 0) {
            return;
        }
        Node<E> curr = null;
        for (int i = 0; i < arr.length; i++) {
            Node<E> node = new Node<>(arr[i]);
            if (i == 0) {
                head.next = node;
                node.prev = head;
            } else {
                curr.next = node;
                node.prev = curr;
            }
            curr = node;
        }
        curr.next = tail;
        tail.prev = curr;
        size = arr.length;
    }

    // create
    public void addFirst(E e) {
        Node<E> node = new Node<>(e);
        Node<E> temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
        size++;
    }

    public void addLast(E e) {
        Node<E> node = new Node<>(e);
        Node<E> temp = tail.prev;
        tail.prev = node;
        node.next = tail;
        node.prev = temp;
        temp.next = node;
        size++;
    }

    public void add(int index, E e) {
        validInsertPosition(index);
        if (index == size) {
            addLast(e);
            return;
        }
        if (index == 0) {
            addFirst(e);
            return;
        }
        Node<E> node = new Node<>(e);
        Node<E> curr = getNode(index);
        Node<E> temp = curr.prev;
        // 前后节点关联自己
        temp.next = node;
        curr.prev = node;
        // 自己关联前后节点
        node.prev = temp;
        node.next = curr;
        size++;
    }

    // delete
    public E removeFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> delE = head.next;
        Node<E> temp = delE.next;

        head.next = temp;
        temp.prev = head;

        delE.prev = null;
        delE.next = null;
        size--;
        return delE.val;
    }

    public E removeLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> delE = tail.prev;
        Node<E> temp = delE.prev;

        tail.prev = temp;
        temp.next = tail;

        delE.prev = null;
        delE.next = null;
        size--;
        return delE.val;
    }

    public E remove(int index) {
        validElementIndex(index);
        Node<E> target = getNode(index);
        Node<E> prev = target.prev;
        Node<E> next = target.next;
        prev.next = next;
        next.prev = prev;
        target.prev  = target.next = null;
        size--;
        return target.val;
    }

    // read
    public E get(int index) {
        validElementIndex(index);
        return getNode(index).val;
    }

    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.next.val;
    }

    // update
    public E set(int index, E val) {
        validElementIndex(index);
        Node<E> target = getNode(index);
        E oldVal = target.val;
        target.val = val;
        return oldVal;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void validInsertPosition(int position) {
        if (position < 0 || position > size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + position + ", Size: " + size);
        }
    }

    private void validElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private Node<E> getNode(int index) {
        validElementIndex(index);
        Node<E> curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public String toString() {
        Node<E> current = head.next;
        StringBuilder sb = new StringBuilder();
        while (current != tail) {
            sb.append(current.val);
            sb.append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
