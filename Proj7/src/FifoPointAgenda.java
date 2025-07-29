// File name: FifoPointAgenda.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Assignment Number: 7
// Description:  Maintains an agenda of Points in FIFO order.
//     Implements PointAgenda interface: add, remove, peek, isEmpty, size.
// Last Changed: 4/1/24

public class FifoPointAgenda implements PointAgenda {
    private Queue<Point> agenda;

    /**
     * Constructs an empty FIFO point agenda
     */
    public FifoPointAgenda() {
        this.agenda = new Queue<>();
    }

    /**
     * Checks if the agenda is empty
     *
     * @return true if the agenda is empty, false otherwise
     */
    public boolean isEmpty() {
        return agenda.isEmpty();
    }

    /**
     * Adds a Point to the agenda
     *
     * @param item The Point to add to the agenda
     */
    public void add(Point item) {
        agenda.enqueue(item);
    }

    /**
     * Removes the next Point from the agenda
     * Throws a RuntimeException if the agenda is empty
     */
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            agenda.dequeue();
        }
    }

    /**
     * Returns the next Point from the agenda without removing it
     * Throws a RuntimeException if the agenda is empty
     *
     * @return The next Point in the agenda
     */
    public Point peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            return agenda.front();
        }
    }

    /**
     * Returns the number of Points in the agenda
     *
     * @return The size of the agenda
     */
    public int size() {
        return agenda.size();
    }
}

