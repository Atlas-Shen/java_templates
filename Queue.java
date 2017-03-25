import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first; // link to least recently added node
    private Node last;  // link to most recently added node
    private int n;      // number of items on the queue

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

    // add item to the end of the list
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (this.isEmpty())
            first = last;
        else
            oldLast.next = last;
        ++n;
    }

    // remove item from the beginning of the list
    public T dequeue() {
        T item = first.item;
        first = first.next;
        --n;
        if (this.isEmpty())
            last = null;
        return item;
    }

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
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
