
/**
 *  Name : Abisa Osei-Amankwah 
 * Purpose:  LinkedLists class implementation 
 * Last Updated:  10/20/23
 * 
 * 
*/


import java.util.Iterator; 
import java.util.ArrayList;

public class LinkedLists<T> implements Queue<T>, Iterable<T>{

    
    private static class Node<T> {

        private Node<T> next;

        private Node<T> prev;

        T data;

        public Node(T item, Node<T> next) {

            this(item, next, null);
        }

        public Node(T item, Node<T> next, Node<T> prev) {

            this.data = item;
            this.next = next;
            this.prev = prev;
        }


        public T getData() {

            return data;

        }

        public void setNext(Node<T> n) {

            this.next = n;

        }

        public void setPrev(Node<T> n) {

            prev = n;
        }

        public Node<T> getNext() {

            return next;
        }

        public Node<T> getPrev() {

            return prev;
        }
    }

    private int size;
    private Node<T> head;
    private Node<T> tail;

    public LinkedLists() {

        size = 0;

        head = null;

        tail = null;
    }

    private class LLIterator implements Iterator<T> {
        private Node<T> walker;

        //constructor for the LLIterator given the head of a list.
        public LLIterator(Node<T> head) {
            walker = LinkedLists.this.head;
        }

        public boolean hasNext() {
            return walker != null;
        }

        
        //Returns the data stored in the next node of the iteration
         
        public T next() {
            T toReturn = walker.getData();

            walker = walker.getNext();

            return toReturn;
        }

        /**
         * Not implemented
         */
        public void remove() {

        }
    }

    /**
     * Returns an iterator over the elements in this list.
     *
     * @return an iterator over the elements in this list.
     */
    public Iterator<T> iterator() {
        return new LLIterator(this.head);
    }

    /**
     * Adds an element to the beginning of the list
     *
     * @param item the element to add to the list
     */
    public void add(T item) {
        Node<T> newNode = new Node<T>(item, head);
        head = newNode;
        // If the list is empty, set the tail to the new node as well
        if (size == 0) {

            tail = newNode;
            
        } 
        else {
            // Otherwise, set the previous pointer of the second node to the new node
            head.getNext().setPrev(newNode);
        }
        size++;
    }

    //Adds an element to the start of the list
    public void addFirst(T item) {

        Node<T> newNode = new Node<T>(item, head, null);

        if (size == 0) {

            tail = newNode;
        } 
        else {

            head.setPrev(newNode);
        }

        head = newNode;
        size++;
    }
    
    //Adds an element to the end of the list
    public void addLast(T item) {
        Node<T> newNode = new Node<T>(item, null, tail);
        tail.setNext(newNode);
        tail = newNode;
        // If the list is empty, set the head to the new node as well
        if (size == 0) {
            head = newNode;
        } else {
            tail.getPrev().setNext(newNode);
        }
        size++;
    }

    /**
     * Adds an element to the list at the specified index
     *
     * @param index the index at which to add the element
     * @param item  the element to add to the list
     */
    public void add(int index, T item) {
        // If the index is 0, add the element to the beginning of the list
        if (index == 0) {

            add(item);
            return;

        }
        // If the index is the last element, add the element to the end of the list
        if (index == size) {

            addLast(item);
            return;
        }
        // If the index is closer to the beginning of the list, start from the beginning
        if (index <= size / 2) {

            Node<T> walker = head;

            for (int i = 0; i < index - 1; i++) {
                walker = walker.getNext();
                Node<T> newNode = new Node<T>(item, walker.next, walker);
                walker.getNext().setPrev(newNode);
                walker.setNext(newNode);
                size++;
            }
        } 
        else {
            // If the index is closer to the end of the list, start from the end
            Node<T> walker = tail;

            for (int i = size - 1; i > index; i--){
                walker = walker.prev;
                Node<T> newNode = new Node<T>(item, walker, walker.prev);
                walker.getPrev().setNext(newNode);
                walker.setPrev(newNode);
                size++;
            }
        }
    }

    /**
     * Gets the element with the given index
     * 
     * @param index the index of the required element
     * @return the element
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            System.out.println("index out of hand");
        }
        if (index <= size / 2) {
            Node<T> walker = head;
            for (int i = 0; i < index; i++) {
                walker = walker.next;
            } // at the end of this for-loop, walker is the
              // indexth node in the list (accounting for 0-indexing)
            return walker.getData();
        } else {
            Node<T> walker = tail;
            for (int i = size - 1; i > index; i--) {
                walker = walker.getPrev();
            } // at the end of this for-loop, walker is the
              // indexth node in the list (accounting for 0-indexing)
            return walker.getData();
        }
    }

    /**
     * Clears the list
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
     * Removes the first item
     * 
     * @return the removed first item
     */
    public T removeFirst() {
        if (size == 0) return null;
        T toReturn = head.getData();
        head = head.getNext();
        if (size == 1) {
            tail = null;
        } else {
            head.setPrev(null);
        }
        size--;
        return toReturn;
    }

    /**
     * Removes the last item
     * 
     * @return the removed last item
     */
    public T removeLast() {
        if (size == 0) return null;
        T toReturn = tail.getData();
        tail = tail.getPrev();
        if (size == 1) {
            head = null;
        } else {
            tail.setNext(null);
        }
        size--;
        return toReturn;
    }
    /**
     * Removes the first item
     * 
     * @return the removed first item
     */
    public T remove() {
        T toReturn = head.getData();
        head = head.getNext();
        size--;
        return toReturn;
    }

    /**
     * Removes a specific item from the list
     * 
     * @param index the index of the item to be removed
     * @return the removed item
     */
    public T remove(int index) {
        if (index == 0) {
            return remove();
        }
        if (index == size - 1) {
            return removeLast();
        }
        if (index <= size / 2) {
            Node<T> walker = head;
            for (int i = 0; i < index; i++)
                walker = walker.getNext();
            walker.getPrev().setNext(walker.getNext());
            walker.getNext().setPrev(walker.getPrev());
            size--;
            return walker.getData();
        } else {
            Node<T> walker = tail;
            for (int i = size - 1; i > index; i--) {
                walker = walker.getPrev();
            }
            walker.getPrev().setNext(walker.getNext());
            walker.getNext().setPrev(walker.getPrev());
            size--;
            return walker.getData();
        }
    }


    public boolean contains(Object o) {
        Node<T> walker = head;
        for (int i = 0; i < size; i++) {
            if (o == walker.getData()) {
                return true;
            }
            walker = walker.getNext();
        }
        return false;
    }


    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (!(o instanceof LinkedLists)) {
            return false;
        }
        LinkedLists<T> oAsALinkedList = (LinkedLists<T>) o;
        int smallestLength = oAsALinkedList.size() < this.size() ? oAsALinkedList.size() : this.size();
        for (int i = 0; i < smallestLength; i++) {
            if (oAsALinkedList.get(i) != this.get(i))
                return false;
        }
        return true;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ArrayList<T> toArrayList() {
        ArrayList<T> array = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            array.add(this.get(i));
        }
        return array;
    }

    @Override
    public void offer(T item) {
        add(item);
    }

    /**
     * 
     * Retrieves, but does not remove, the head of queue/stack.
     * 
     * @return the head of this queue/stack, or null if this queue/stack is empty
     */
    @Override
    public T peek() {
        return head.getData();
    }

    /**
     * 
     * Retrieves and removes the head of this queue, or returns null if this queue
     * is empty.
     * 
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public T poll() {
        return removeFirst();
    }

}

