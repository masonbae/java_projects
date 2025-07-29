// File name: Queue.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 7
// Description: generic queue class
// Last Changed: 4/1/24
//

public class Queue<T> {

    /**
     * Node class representing an element in the queue
     *
     * @param <T> The type of the element stored in the node
     */
    private static class Node<T> {
        T item;
        Node<T> next;

        /**
         * Constructs a new Node with the specified item and next node reference
         *
         * @param item The item to be stored in the node
         * @param next The next node in the queue
         */
        Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    /**
     * Constructs an empty queue
     */
    public Queue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    /**
     * Checks whether the queue is empty.\
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Adds an item to the end of the queue
     *
     * @param item The item to add
     *
     * pre: The queue exists
     * post: The item is added to the end of the queue, size is incremented
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    /**
     * Removes the item at the front of the queue
     *
     * pre: The queue is not empty
     * post: The front item is removed from the queue, size is decremented
     *
     * @throws RuntimeException if the queue is empty
     */
    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }

    /**
     * Returns the item at the front of the queue without removing it
     *
     * pre: The queue is not empty
     * post: The front item of the queue is returned
     *
     * @return The item at the front of the queue
     * @throws RuntimeException if the queue is empty
     */
    public T front() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return front.item;
    }

    /**
     * Returns the number of items in the queue
     *
     * @return The size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * Creates a copy of this queue
     *
     * @return A new queue that is a clone of this queue
     */
    public Queue<T> clone() {
        Queue<T> clonedQueue = new Queue<>();
        Node<T> current = this.front;
        while (current != null) {
            clonedQueue.enqueue(current.item);
            current = current.next;
        }
        return clonedQueue;
    }

    /**
     * Determines whether another queue is equal to this one
     *
     * @param other The object to compare against
     * @return true if the other object is a Queue with
     * the same elements in the same order, false otherwise
     */
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Queue)) return false;
        Queue<?> that = (Queue<?>) other;
        if (this.size != that.size) return false;

        Node<T> currentThis = this.front;
        Node<?> currentThat = that.front;
        while (currentThis != null && currentThat != null) {
            if (!currentThis.item.equals(currentThat.item)) {
                return false;
            }
            currentThis = currentThis.next;
            currentThat = currentThat.next;
        }
        return true;
    }
}
