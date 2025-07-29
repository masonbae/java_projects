// File name: Stack.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 7
// Description: generic stack class
// Last Changed: 4/1/24

public class Stack<T> {
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * Default Constructor -- Create an empty stack
     */
    public Stack() {
        head = null;
        size = 0;
    }

    /**
     * Checks if the stack is empty
     * pre: A stack exists
     * post: Returns true if it IS empty, false if NOT empty
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Pushes an item on top of the stack
     * pre: Stack exists and item is passed
     * post: the item is placed on top of the stack, and size is incremented
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /**
     * Pops the top item off the stack
     * pre: Stack exists
     * post: Removes item on top of stack. If the stack was already empty,
     * throws a RuntimeException exception
     */
    public void pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        head = head.next;
        size--;
    }

    /**
     * Returns the top item of the stack without popping it
     * pre: Stack exists
     * post: Returns item on top of stack,
     * If the stack was already empty, throws a RuntimeException exception
     */
    public T top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return head.value;
    }

    /**
     * Returns the number of items on the stack
     * post: Returns size from the private section of class
     */
    public int size() {
        return size;
    }

    /**
     * Clone this Stack to a new Stack
     * post: Returns a clone of the current Stack with a deep copy of its elements
     */
    public Stack<T> clone() {
        Stack<T> clonedStack = new Stack<>();
        if (!isEmpty()) {
            clonedStack.head = new Node<>(this.head.value);
            Node<T> currentThis = this.head.next;
            Node<T> currentCloned = clonedStack.head;

            while (currentThis != null) {
                Node<T> newNode = new Node<>(currentThis.value);
                currentCloned.next = newNode;
                currentThis = currentThis.next;
                currentCloned = currentCloned.next;
            }
        }
        clonedStack.size = this.size;
        return clonedStack;
    }

    /**
     * Determine if two Stack objects are equal
     * @param other The object to compare with this Stack
     * @return true if the two Stacks are equivalent (same size and data)
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Stack)) return false;
        Stack<?> that = (Stack<?>) other;
        if (this.size != that.size) return false;

        Node<T> currentThis = this.head;
        Node<?> currentThat = that.head;
        while (currentThis != null && currentThat != null) {
            if (!currentThis.value.equals(currentThat.value)) return false;
            currentThis = currentThis.next;
            currentThat = currentThat.next;
        }
        return true;
    }


}
