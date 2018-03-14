package hu.crs.codewars.fivekyu.josephussurvivor;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kata {
    public static int josephusSurvivor(final int n, final int k) {
        CircleList<Integer> circleList = new CircleList<>(IntStream.of(IntStream.range(1, n + 1).toArray()).boxed().collect(Collectors.toList()));

        int i = 0;

        Iterator<Integer> iterator = circleList.iterator();
        while (iterator.hasNext()) {
            i++;
            if (i == k) {
                i = 0;
                iterator.remove();
            } else {
                iterator.next();
            }
        }

        return circleList.getNode();
    }

    private static class CircleList<E> implements Iterable<E>{
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

        E getNode() {
            return node.element;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                /**
                 * Next element of the circle list. In case it has only one element by convention it doesn't have next.
                 * @return if has next element or not
                 */
                @Override
                public boolean hasNext() {
                    return first.next != first;
                }

                @Override
                public E next() {
                    node = node.next;
                    if (node == null) {
                        throw new NoSuchElementException();
                    }
                    return node.element;
                }

                @Override
                public void remove() {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                    if (node == first) {
                        first = node.next;
                    }
                    node = node.next;
                }
            };
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
