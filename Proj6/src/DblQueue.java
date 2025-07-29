// File name: DblQueue.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 6
// Description: holds doubles and creates an unbounded
// queue class based on a singly linked list
// Last Changed: 3/24/24
//

public class DblQueue {

    private static class Node {
        double item;
        Node next;

        Node(double item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public DblQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(double item) {
        Node newNode = new Node(item, null);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
    }

    public double front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return front.item;
    }

    public int size() {
        return size;
    }

    public DblQueue clone() {
        DblQueue clonedQueue = new DblQueue();
        Node current = this.front;
        while (current != null) {
            clonedQueue.enqueue(current.item);
            current = current.next;
        }
        return clonedQueue;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DblQueue that = (DblQueue) other;
        if (this.size != that.size) return false;
        Node currentThis = this.front;
        Node currentThat = that.front;
        while (currentThis != null) {
            if (currentThis.item != currentThat.item) {
                return false;
            }
            currentThis = currentThis.next;
            currentThat = currentThat.next;
        }
        return true;
    }

}
