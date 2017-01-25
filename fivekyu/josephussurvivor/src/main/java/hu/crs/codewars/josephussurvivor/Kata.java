package hu.crs.codewars.josephussurvivor;

import java.util.Iterator;

public class Kata {
    public static int josephusSurvivor(final int n, final int k) {
        CircleList<Integer> circleList = new CircleList<>();

        for (int i = 1; i <= n; i++) {
            circleList.add(i);
        }
        circleList.init();

        int i = 1;
        Iterator iterator = circleList.iterator();
        while (iterator.hasNext()) {
            if (i == k) {
                i = 1;
                circleList.remove();
            }
            i++;
        }

        return circleList.getElement();
    }

    private static class CircleList<E> implements Iterable<E> {
        Node<E> node;

        public void add(E element) {
            if (node == null) {
                node = new Node<>(element, null, null);
                node.previous = node;
                node.next = node;
            } else {
                Node<E> newNode = new Node<>(element, node, node.next);
                node.next = newNode;

                node = newNode;
            }
        }

        public void remove() {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }

        public E getElement() {
            return node.element;
        }

        public void init() {
            node = node.next;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                @Override
                public boolean hasNext() {
                    return node.next != node;
                }

                @Override
                public E next() {
                    return node.next.element;
                }
            };
        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

}
