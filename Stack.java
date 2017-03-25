import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node first; // top of stack (most recently added node)
    private int n;      // number of items

    private class Node { // nested class to define nodes
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    // add item to top of stack
    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        ++n;
    }

    // remove item from top of stack
    public T pop() {
        T item = first.item;
        first = first.next;
        --n;
        return item;
    }

    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {}
    }
}
