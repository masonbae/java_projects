// File name: LifoPointAgenda.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Assignment Number: 7
// Description:  Maintains an agenda of Points in LIFO order.
//     Implements PointAgenda interface: add, remove, peek, isEmpty, size.
// Last Changed: 4/1/24

public class LifoPointAgenda implements PointAgenda {
    private Stack<Point> agenda;

    /**
     * Constructs an empty LIFO point agenda
     */
    public LifoPointAgenda() {
        this.agenda = new Stack<>();
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
     * @param item The Point to be added to the agenda
     */
    public void add(Point item) {
        agenda.push(item);
    }

    /**
     * Removes the next Point from the agenda
     * If the agenda is empty, throws a RuntimeException
     */
    public void remove() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            agenda.pop();
        }
    }

    /**
     * Returns the next Point from the agenda without removing it
     * If the agenda is empty, throws a RuntimeException
     *
     * @return The next Point in the agenda
     */
    public Point peek() {
        if (isEmpty()) {
            throw new RuntimeException();
        } else {
            return agenda.top();
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


