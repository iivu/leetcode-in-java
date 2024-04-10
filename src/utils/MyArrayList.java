package utils;

import java.util.NoSuchElementException;

public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 1;
    private E[] data;
    private int capacity = 0;
    private int size = 0;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // create
    public void add(int index, E e) {
        validInsertPosition(index);
        if (size == capacity) {
            resize(capacity * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        if (size == capacity) {
            resize(capacity * 2);
        }
        data[size] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // delete
    public E remove(int index) {
        validElementIndex(index);
        if (size == capacity / 4) {
            resize(capacity / 2);
        }
        E deletedElement = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        data[size - 1] = null;
        size--;
        return deletedElement;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    // read
    public E get(int index) {
        validElementIndex(index);
        return data[index];
    }

    // update
    public E set(int index,E e) {
        validElementIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int newCapacity) {
        if (size > newCapacity) {
            return;
        }
        E[] newData = (E[]) new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
        capacity = newCapacity;
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
}
