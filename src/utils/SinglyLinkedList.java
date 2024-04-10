package utils;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
        }
    }

    private final Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public SinglyLinkedList() {
        head = new Node<>(null);
        tail = head;
    }

    // create
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
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
        Node<E> newNode = new Node<>(e);
        Node<E> prev = getNode(index - 1);
        Node<E> temp = prev.next;
        prev.next = newNode;
        newNode.next = temp;
        size++;
    }

    // delete
    public E removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> first = head.next;
        head.next = first.next;
        if (size == 1) {
            tail = head;
        }
        size--;
        return first.val;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        E val = tail.val;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public E remove(int index) {
        validElementIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<E> prev = getNode(index - 1);
        Node<E> target = prev.next;
        prev.next = target.next;
        target.next = null;
        if (index == size - 1) {
            tail = prev;
        }
        size--;
        return target.val;
    }

    // update
    public E set(int index, E val) {
        validElementIndex(index);
        Node<E> target = getNode(index);
        E oldVal = target.val;
        target.val = val;
        return oldVal;
    }

    // read
    public E get(int index) {
        validElementIndex(index);
        return getNode(index).val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
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
}
