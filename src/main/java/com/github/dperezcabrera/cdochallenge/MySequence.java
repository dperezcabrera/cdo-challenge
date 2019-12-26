package com.github.dperezcabrera.cdochallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *
 * @author David Pérez Cabrera <dperezcabrera@gmail.com>
 * @param <T>
 */
public class MySequence<T> {

    private static final Node DUPLICATE_VALUE_NODE = new Node(null, null);

    private Map<T, Node<T>> insertedValues = new HashMap<>();
    private Node<T> head = null;
    private Node<T> tail = null;

    public void add(T value) {
        if (value == null) {
            throw new NullPointerException("value can not be null");
        }
        Node<T> node = insertedValues.get(value);
        if (node == null) {
            insertNodeIntoList(value);
        } else if (node != DUPLICATE_VALUE_NODE) {
            removeNodeFromList(node);
        }
    }

    public Optional<T> getFirstNonDuplicated() {
        if (head != null) {
            return Optional.of(head.value);
        }
        return Optional.empty();
    }

    private void insertNodeIntoList(T value) {
        Node<T> node = new Node<>(value, tail);
        if (head == null) {
            head = node;
        } else {
            tail.next = node;
        }
        tail = node;
        insertedValues.put(value, node);
    }

    private void removeNodeFromList(Node<T> node) {
        if (head == node) {
            head = node.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            node.prev.next = node.next;
        }
        if (tail == node) {
            tail = node.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            node.next.prev = node.prev;
        }
        insertedValues.put(node.value, DUPLICATE_VALUE_NODE);
        node.next = null;
        node.prev = null;
        node.value = null;
    }

    private static class Node<T> {

        private T value;
        private Node<T> prev;
        private Node<T> next = null;

        public Node(T n, Node<T> prev) {
            this.value = n;
            this.prev = prev;
        }
    }
}
