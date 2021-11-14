package io.chengsean.programstudy.algorithms.linked;

import java.util.Iterator;
import java.util.Objects;

public class ReversesLinkedList<T> implements Iterable<T> {
    private int size;
    private Node<T> head = new Node<>(null);

    public ReversesLinkedList() {
    }

    public ReversesLinkedList(ReversesLinkedList<T> list) {
        this.head.next = Objects.requireNonNull(list).head;
    }

    public T add(T t) {
        Node<T> node = new Node<>(t);
        node.next = this.head;
        this.head = node;
        this.size ++;
        return t;
    }



    static class Node<T> {
        private final T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return Objects.nonNull(head.next);
            }

            @Override
            public T next() {
                Node<T> node = head;
                head = head.next;
                return node.data;
            }
        };
    }

}
