package com.thoughtworks.collection;

import java.util.NoSuchElementException;

public class SingleLink<T> {

    private Node head = null;
    private Node tail = null;

    class Node {
        private T item;
        private Node next;
        Node(T item) {
            this.item = item;
            this.next = null;
        }
    }

    public void addTailPointer(T item) {
        Node node = new Node(item);
        if (this.tail != null) {
            this.tail.next = node;
            this.tail = this.tail.next;
        } else {
            this.tail = this.head = node;
        }
    }
    public T getNode(int index) {
        Node cur = this.head;
        int postion = 1;
        while (cur != null) {
            if (postion == index) {
                return cur.item;
            }
            cur = cur.next;
            postion += 1;
        }
        throw new NoSuchElementException();
    }
}