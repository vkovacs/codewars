package hu.crs.codewars.josephussurvivor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static int josephusSurvivor(final int n, final int k) {
        CircleList<Integer> circleList = new CircleList<>(IntStream.of(IntStream.range(1, n + 1).toArray()).boxed().collect(Collectors.toList()));

        int i = 0;
        while (!circleList.isOneNodeList()) {
            i++;
            if (i == k) {
                i = 0;
                circleList.remove();
            } else {
                circleList.next();
            }
        }

        return circleList.getNode().element;
    }

    private static class CircleList<E> {
        Node<E> first;
        Node<E> node;

        CircleList(List<E> list) {
            list.forEach(this::add);
            initFirst();
        }

        private void add(E element) {
            if (node == null) {
                node = new Node<>(element, null, null);
                node.previous = node;
                node.next = node;
                first = node;
            } else {
                Node<E> newNode = new Node<>(element, node, first);
                node.next = newNode;
                first.previous = newNode;
                node = newNode;
            }
        }

        private void initFirst() {
            node = first;
        }

        void remove() {
            node.previous.next = node.next;
            node.next.previous = node.previous;
            if (node == first) {
                first = node.next;
            }
            node = node.next;
        }

        Node<E> getNode() {
            return node;
        }

        boolean isOneNodeList() {
            return first.next == first;
        }

        Node<E> next() {
            node = node.next;
            return node;
        }

    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        Node(E element, Node<E> previous, Node<E> next) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }

}
