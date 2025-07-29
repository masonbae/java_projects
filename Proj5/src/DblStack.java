// File name: DblStack.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS 2201
// Assignment Number: 5
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description: A stack of double values
// Last Changed: 3/17/24

public class DblStack {

    private Node head;
    private int size;

    private class Node {
        double value;
        Node next;

        Node(double value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Default Constructor -- Create an empty stack.
     */
    public DblStack() {
        head = null;
        size = 0;
    }

    /**
     *  isEmpty
     *  Checks if the stack is empty
     *  pre:  A stack exists.
     *  post: Returns true if it IS empty, false if NOT empty.
     */
    public boolean isEmpty() {
        return head == null;
    }


    /**
     *  push
     *  Pushes an item on top of the stack.
     *  pre:  Stack exists and item is passed.
     *  post: the item is placed on top of the stack, and size is incremented.
     */
    public void push(double item) {
        Node newNode = new Node(item);
        newNode.next = head;
        head = newNode;
        size++;
    }


    /**
     * pop
     * Pops the top item off the stack.
     * pre:  Stack exists.
     * post: Removes item on top of stack.  If the stack
     *       was already empty, throws a RuntimeException exception.
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        head = head.next;
        size--;
    }


    /**
     *  top
     *  Returns the top item of the stack without popping it.
     *  pre:  Stack exists.
     *  post: Returns item on top of stack.  If the stack
     *        was already empty, throws a RuntimeException exception.
     */
    public double top() {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return head.value;
    }


    /**
     *  size
     *  Returns the number of items on the stack.
     *  post: Returns size from the private section of class.
     */
    public int size() {
        return size;
    }


    /**
     * clone
     * Return a new DblStack object that is a clone of the 'this' object.
     * The clone should have its own list (of the same size) and contain all the values
     * of 'this' object.
     */
    public DblStack clone() {
        DblStack clonedStack = new DblStack();
        if (!isEmpty()) {
            clonedStack.head = new Node(this.head.value);
            Node currentThis = this.head.next;
            Node currentCloned = clonedStack.head;

            while (currentThis != null) {
                currentCloned.next = new Node(currentThis.value);
                currentThis = currentThis.next;
                currentCloned = currentCloned.next;
            }
        }
        clonedStack.size = this.size;
        return clonedStack;
    }


    /**
     * equals
     * Determine if two DblStack objects are equal
     * @param other -- The object to compare
     * @return true if the two DblStacks are equivalent (same size and same data)
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof DblStack)) return false;
        DblStack that = (DblStack) other;
        if (this.size != that.size) return false;

        Node currentThis = this.head;
        Node currentThat = that.head;
        while (currentThis != null && currentThat != null) {
            if (Double.compare(currentThis.value, currentThat.value) != 0) return false;
            currentThis = currentThis.next;
            currentThat = currentThat.next;
        }
        return true;
    }


}
