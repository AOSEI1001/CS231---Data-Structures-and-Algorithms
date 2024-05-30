
/*
 *  Name : Abisa Osei-Amankwah 
 * Purpose:  LinkedLists class implementation 
 * Last Updated:  10/16/23
 * 
 * 
 */
import java.util.Iterator; // defines the Iterator interface
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections; // contains a shuffle function

public class LinkedLists<T> implements Stack<T>, Iterable<T> { // T, generic type

    private Node<T> head;
    private int numNodes;

    private class LLIterator implements Iterator<T> {

        private LinkedLists<T>.Node<T> head;

        public LLIterator(Node<T> head) {
            this.head = head;

        }

        public boolean hasNext() {

            if (head != null) {

                return true;
            }

            else {

                return false;
            }

        }

        public T next() {

            if (head != null) { // maybe use has next instead for edge case

                Node<T> walker = head;

                head = walker.getNext();

                return walker.getData();

            }

            return null;

        }

        public void remove() {

        }

        public Iterator<T> iterator() {
            return new LLIterator(head);
        }
    }

    private class Node<T> {

        private Node<T> next;
        T data;

        public Node(T item, Node<T> NextNode) {

            this.next = null;
            this.data = item;

        }

        public T getData() {

            return data;
        }

        public void setNext(Node<T> n) {
            this.next = n;

        }

        public Node<T> getNext() {

            return next;

        }
    }

    public LinkedLists() {
        head = null;
        numNodes = 0;

    }

    public void add(T item) {
        Node<T> newNode = new Node<T>(item, null); // MAKING A NODE WITH ITEM IN IT

        newNode.setNext(this.head); // setting the next node
        head = newNode; // making the newNode the current head
        numNodes++;

    }

    public void add(int index, T item) {

        Node<T> newNode = new Node<T>(item, null);
        Node<T> walker = head;

        if (index == 0) {
            add(item);
        } else {

            for (int i = 0; i < index - 1; i++) {
                walker = walker.getNext();
            }

            newNode.setNext(walker.getNext());
            walker.setNext(newNode);
            numNodes++;

        }

    }

    public int size() {

        return numNodes;
    }

    public void clear() {

        this.head = null;
        numNodes = 0;

    }

    public boolean equals(Object o) {

        Node<T> walker = head;

        if (!(o instanceof LinkedLists)) {
            return false;
        }

        // If I have reached this line, o must be a LinkedList
        LinkedLists oAsALinkedList = (LinkedLists) o;

        Node<T> otherWalker = oAsALinkedList.head;

        while (walker != null) {
            if (!walker.getData().equals(otherWalker.getData())) {
                return false;

            }

            walker = walker.getNext();
            otherWalker = otherWalker.getNext();
        }
        return true;

    }

    public boolean contains(Object o) {

        Node<T> walker = head;

        for (int i = 0; i < size(); i++) {

            if (walker.getData().equals(o)) {

                return true;

            }

            walker = walker.getNext();

        }
        return false;

    }

    public T get(int index) {

        Node<T> Walker = head;

        for (int i = 0; i < index; i++) {
            Walker = Walker.next;

        }
        return Walker.data;

    }

    public boolean isEmpty() {

        if (size() == 0) {
            return true;
        }

        return false;
    }

    public T remove() {
        Node<T> walker = head;

        head = walker.getNext();

        numNodes--;

        return walker.getData();

    }

    public T remove(int index) {

        // add edge cases, if the list is empty

        Node<T> walker = head;

        if (index == 0) {

            T removedData = head.getData();

            head = head.getNext();

            numNodes--;

            return removedData;

        }

        for (int i = 0; i < index - 1; i++) {
            walker = walker.getNext();
        }

        T toReturn = walker.getNext().getData();
        walker.setNext(walker.getNext().getNext());
        numNodes--;

        return toReturn;
    }

    public String toString() {

        ArrayList<T> list = new ArrayList<T>();

        Node<T> walker = head;

        while (walker != null) {

            list.add((T) walker.getData());

            walker = walker.getNext();

        }
        return list.toString();

    }

    public ArrayList<T> toArrayList() {

        ArrayList<T> list = new ArrayList<T>();

        Node<T> walker = head;

        while (walker != null) {

            list.add(walker.getData());

            walker = walker.getNext();
        }
        return list;
    }

    @Override
    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }

    // @Override

    /**
     * returns the item at the top of the stack
     */
    public T peek() {

        return this.get(0);
    }

    /**
     * removes and returns the item on the top of the stack
     */
    public T pop() {

        // ((LLIterator) this.get(0)).remove();
        // return remove(0);
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }

        T poppedData = this.remove(0);
        // head = head.getNext();
        // numNodes--;
        return poppedData;

    }

    @Override
    /**
     * adds the given item to the top of the stack
     */
    public void push(T item) {

        this.add(0, item);
        // Node<T> newNode = new Node<>(item, head);
        // head = newNode;
        // numNodes++;
    }

}
