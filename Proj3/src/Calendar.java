// File name: Calendar.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 2/14/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 3
// Description: Implementation of a Calendar class, where a Calendar is a collection
//              of Reminders kept in sorted order by Date.

public class Calendar {

    /**
     * RemNode -- represents a single node in a linked list. Each node contains a
     * reference to a Reminder, and a reference to the next node.
     * The data fields are public for easy access. No accessors/mutators are
     * provided since the user has direct access to the data.
     * Several constructors are provided for convenience.
     * <p>
     * Note: you are NOT allowed to change this class
     */

    public class RemNode {
        public Reminder rem;         // Each node contains a Reminder
        public RemNode next;         // And a reference to the next node

        public RemNode() {
            this(new Reminder(), null);
        }

        public RemNode(Reminder rem) {
            this(rem, null);
        }

        public RemNode(Reminder rem, RemNode next) {
            this.rem = rem;
            this.next = next;
        }
    }


    /**
     * numRem -- number of Reminders currently in the Calendar
     */
    private int numRem;


    /**
     * remList -- reference to head of the linked list
     */
    private RemNode remList;


    /**
     * Default Constructor -- Create an empty Calendar (one with zero Reminders).
     */
    public Calendar() {
        remList = null;
        numRem = 0;
    }


    // accessors *****************************


    /**
     * isEmpty -- Returns true if the Calendar is empty (contains no Reminders)
     */
    public boolean isEmpty() {
        return numRem == 0;
    }


    /**
     * getNumRem -- Return the total number of Reminders in the Calendar.
     */
    public int getNumRem() {
        return numRem;
    }


    /**
     * getRem(int index)
     * <p>
     * Purpose:  returns the Reminder at the specified index in the Calendar,
     * throw exception if index is bad.
     *
     * @param index - the index of the desired Reminder; using zero-based indexing
     * @return Reminder - the Reminder at the specified index
     * <p>
     * Behavior:
     * 1. If the index is invalid, throw an IllegalArgumentException
     * 2. Otherwise, return the Reminder at the specified index
     * NOTE: Normally a Calendar class would not support indexing to access Reminders, as the user
     * does not think of storing Reminders by index. We have only added this method so that we
     * can verify that your insert method works correctly.
     */
    public Reminder getRem(int index) {
        if (index < 0 || index >= numRem) {
            throw new IllegalArgumentException("Invalid index");
        }

        RemNode curr = remList;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.rem;
    }


    /**
     * count(Date theDate)
     * <p>
     * Purpose: Returns the number of Reminders that occur on a specific date
     *
     * @param theDate - the date of the Reminders we are to count
     * @return int - the number of Reminders on the specified date
     */
    public int count(Date theDate) {
        int count = 0;

        for (RemNode curr = remList; curr != null && curr.rem != null;
             curr = curr.next) {
            if (curr.rem.getDate().equals(theDate)) {
                count++;
            }
        }

        return count;
    }


    /**
     * findRem(Date theDate)
     * <p>
     * Purpose: Find first reminder for the given date and return its index
     *
     * @param theDate -- the date to search for
     * @return int value containing the index of the first reminder with the specified date,
     * or -1 if no reminders with that date exist
     */
    public int findRem(Date theDate) {
        int index = 0;

        for (RemNode curr = remList; curr != null; curr = curr.next) {
            if (curr.rem.getDate().equals(theDate)) {
                return index;
            }
            index++;
        }

        return -1;
    }


    /**
     * findRem(String str)
     * <p>
     * Purpose: Find first reminder with the given message and return its index
     *
     * @param str -- the message to search for
     * @return int value containing the index of the first reminder with the specified
     * message, or -1 if no reminders with that message exist.
     * String comparison is case-sensitive.
     */
    public int findRem(String str) {
        int index = 0;

        for (RemNode curr = remList; curr != null; curr = curr.next) {
            if (curr.rem.getMsg().equals(str)) {
                return index;
            }
            index++;
        }

        return -1;
    }


    /**
     * toString()
     * <p>
     * Purpose: Return a string of all the Reminders
     *
     * @return String containing all the Reminders in sorted order with each & every
     * Reminder followed immediately by a newline character.
     * Returns an empty string if the Calendar is empty
     * Note: use the toString() method of the Reminder class to format each Reminder
     */
    public String toString() {
        if (numRem == 0) {
            return "";
        }

        String result = "";

        for (RemNode curr = remList; curr != null; curr = curr.next) {
            result += curr.rem.toString() + "\n";
        }

        return result;
    }


    /**
     * toString(int index)
     * <p>
     * Purpose: Return a string of the reminder at a particular index in the Calendar
     *
     * @param index -- the index of the desired reminder
     * @return string containing the reminder
     * <p>
     * Behavior:
     * 1. Returns string containing the reminder at the given index (no newline
     * character added)
     * 2. Follows 0-based indexing
     * 3. If the Calendar is empty or the index is invalid, returns an empty string
     * Note: use the toString() method of the Reminder class to format each Reminder
     */
    public String toString(int index) {
        if (numRem == 0 || index < 0 || index >= numRem) {
            return "";
        }

        RemNode curr = remList;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.rem.toString();

    }


    /**
     * toString(String str)
     * <p>
     * Purpose: Return a string of all reminders whose message matches the provided string
     *
     * @param str -- the string we are supposed to check for matches
     * @return string containing all the matching reminders, in sorted order, each reminder
     * followed immediately by a newline character.
     * Behavior:
     * 1. Finds any reminders having its message same as the provided string (in a case-
     * sensitive manner)
     * 2. If no match is found, returns an empty string
     * 3. If matches are found, append them on the return string in sorted order each
     * followed by a newline character.
     * Note: use the toString() method of the Reminder class to format each Reminder
     */
    public String toString(String str) {
        String result = "";

        for (RemNode curr = remList; curr != null; curr = curr.next) {
            if (curr.rem.toString().equals(str)) {
                result += curr.rem.toString() + "\n";
            }
        }

        return result;
    }


    /**
     * toString(Date d)
     * <p>
     * Purpose: Return a string of all reminders for a given date
     *
     * @param d -- the date we are supposed to check for matches
     * @return string containing all the matching reminders, in sorted order, each reminder
     * followed immediately by a newline character.
     * Behavior:
     * 1. Finds all reminders on the provided date
     * 2. If no match is found, returns an empty string
     * 3. If matches are found, append them on the return string in sorted order each
     * followed by a newline character.
     * <p>
     * Note: see addRem() for the definition of sorted order of Reminders with the
     * same date.
     * Note: use the toString() method of the Reminder class to format each Reminder
     */
    public String toString(Date d) {
        return toString(d, d);
    }


    /**
     * toString(Date d1, Date d2)
     * <p>
     * Purpose: Return a string of reminders in a range of two given dates
     *
     * @param d1 & d2 -- the range of Dates
     * @return string containing all the matching reminders, in sorted order, each reminder
     * followed immediately by a newline character.
     * <p>
     * Behavior:
     * 1. If the Calendar contains no dates in the given range, return an empty string
     * 2. Create a string containing all the reminders, in sorted order, which are later
     * than or equal to the smaller of the two dates and are earlier than or equal to
     * the larger of the two dates, with each reminder followed immediately by a
     * newline character. The relative order of d1 & d2 is unknown.
     * Note: use the toString() method of the Reminder class to format each Reminder
     */
    public String toString(Date d1, Date d2) {
        String result = "";

        for (RemNode curr = remList; curr != null; curr = curr.next) {
            Date d = curr.rem.getDate();
            if ((!d.lessthan(d1) && !d.greaterthan(d2)) ||
                    (!d.lessthan(d2) && !d.greaterthan(d1))) {
                result += curr.rem.toString() + "\n";
            }
        }

        return result;
    }


    /**
     * equals(Object other)
     * <p>
     * Purpose:  compare two objects for equality
     *
     * @param other -- an object
     * @return true if the two Calendar objects are equal, otherwise false
     * <p>
     * Behavior: Two Calendar objects are considered equal if they contain the same
     * number of Reminders, and they contain equal Reminders in the same exact order.
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Calendar))
            return false;

        Calendar otherCalendar = (Calendar) other;

        if (this.numRem != otherCalendar.numRem)
            return false;

        RemNode thisCurr = this.remList;
        RemNode otherCurr = otherCalendar.remList;

        while (thisCurr != null && otherCurr != null) {
            if (!thisCurr.rem.equals(otherCurr.rem)) {
                return false;
            }
            thisCurr = thisCurr.next;
            otherCurr = otherCurr.next;
        }

        return true;
    }


    // mutators *****************************


    /**
     * addRem(Reminder rem)
     * <p>
     * Purpose: add/insert a reminder in the array of reminder objects
     * Parameters: Reminder rem - the reminder to be added
     * Returns: int - the index position of the inserted reminder
     * <p>
     * Behavior:
     * 1. In case of the Calendar being empty: insert as the first element
     * 2. In case of a non-empty Calendar: insert Reminder in sorted order
     * 3. In case of already existing Reminder with same date: insert new reminder
     * before (ahead of) the existing one.
     * 4. Return the index of the inserted reminder, using zero-based indexing
     * 5. Operates in linear time.
     * Note: Normally this method would be a void method and not return any value. We have it
     * return the index of where the reminder was inserted so that we can verify that the
     * reminder was inserted in the correct position in the array.
     */
    public int addRem(Reminder rem) {
        RemNode newNode = new RemNode(rem);
        int index = 0;

        if (remList == null || newNode.rem.getDate().lessthan(remList.rem.getDate())) {
            newNode.next = remList;
            remList = newNode;
            numRem++;
            return index;
        }

        RemNode current = remList;
        while (current.next != null && current.next.rem.getDate().lessthan(rem.getDate())) {
            current = current.next;
            index++;
        }

        newNode.next = current.next;
        current.next = newNode;
        numRem++;

        return index;
    }


    /**
     * deleteRem()
     * <p>
     * Purpose: Deletes all reminders earlier than today's date
     *
     * @return int - the number of Reminders deleted
     * <p>
     * Implementation Notes:
     * 1) The default constructor of the Date class initializes a Date object to today's
     * date.
     */
    public int deleteRem() {
        Date day = new Date();
        int count = 0;

        while (remList != null && remList.rem.getDate().lessthan(day)) {
            remList = remList.next;
            count++;
        }

        if (remList == null) {
            return count;
        }

        RemNode current = remList;
        while (current.next != null) {
            if (current.next.rem.getDate().lessthan(day)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }

        numRem -= count;

        return count;
    }


    /**
     * deleteRem(int index)
     * <p>
     * Purpose: Deletes reminder object at a provided index position
     *
     * @param index -- index of target reminder
     * @return the number of reminders deleted
     * <p>
     * Notes:
     * 1) If the index is invalid, no deletions will be performed and zero is returned
     */
    public int deleteRem(int index) {
        if (index < 0 || remList == null || index > numRem) {
            return 0;
        }

        if (index == 0) {
            remList = remList.next;
            numRem--;
            return 1;
        }

        int currentIndex = 0;
        RemNode current = remList;

        while (current != null && currentIndex < index - 1) {
            current = current.next;
            currentIndex++;
        }

        if (current == null || current.next == null) {
            return 0;
        }

        current.next = current.next.next;
        numRem--;

        return 1;
    }


    /**
     * deleteRem(String str)
     * <p>
     * Purpose: Delete all reminders whose message matches a given string
     *
     * @param str -- the message to search for (case-sensitive)
     * @return number of reminders deleted
     */
    public int deleteRem(String str) {
        int count = 0;
        while (remList != null && remList.rem.getMsg().equals(str)) {
            remList = remList.next;
            count++;
        }

        RemNode current = remList;
        while (current != null && current.next != null) {
            if (current.next.rem.getMsg().equals(str)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        numRem -= count;

        return count;
    }


    /**
     * deleteRem(Reminder rem)
     * <p>
     * Purpose: Delete all occurrences of the given reminder
     *
     * @param rem -- the reminder to be deleted
     * @return number of reminders deleted
     */
    public int deleteRem(Reminder rem) {
        int count = 0;

        while (remList != null && remList.rem.equals(rem)) {
            remList = remList.next;
            count++;
        }

        RemNode current = remList;
        while (current != null && current.next != null) {
            if (current.next.rem.equals(rem)) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }
        numRem -= count;

        return count;
    }


    /**
     * deleteRem(Date d)
     * <p>
     * Purpose: Deletes all reminders on a particular date
     *
     * @param d -- the date of reminders to be deleted
     * @return number of reminders deleted
     */
    public int deleteRem(Date d) {
        return deleteRem(d, d);
    }


    /**
     * deleteRem(Date d1, Date d2)
     * <p>
     * Purpose: Deletes all reminders between a range of two given dates
     *
     * @param d1 & d2 -- the range of dates
     * @return number of reminders deleted
     * <p>
     * Behavior:
     * 1. If the Calendar contains no dates in the given range, perform no deletions &
     * return zero
     * 2. Delete all Reminders which are later than or equal to the smaller of the two
     * dates and are earlier than or equal to the larger of the two dates. Return the
     * number deleted. The relative order of d1 & d2 is unknown.
     */
    public int deleteRem(Date d1, Date d2) {
        int count = 0;
        Date start, end;

        if (d1.lessthan(d2)) {
            start = d1;
            end = d2;
        } else {
            start = d2;
            end = d1;
        }

        while (remList != null && (remList.rem.getDate().greaterthan(start) || remList.rem.getDate().equals(start))
                && (remList.rem.getDate().lessthan(end) || remList.rem.getDate().equals(end))) {
            remList = remList.next;
            count++;
        }

        RemNode current = remList;
        while (current != null && current.next != null) {
            if ((current.next.rem.getDate().greaterthan(start) || current.next.rem.getDate().equals(start))
                    && (current.next.rem.getDate().lessthan(end) || current.next.rem.getDate().equals(end))) {
                current.next = current.next.next;
                count++;
            } else {
                current = current.next;
            }
        }

        numRem -= count;

        return count;
    }


    /**
     * clone() -- Return a new Calendar object that is a clone of the 'this' object.
     * The clone should have its own linked list (of the same size) and contain all the Reminders
     * of 'this' object.
     * Note: Reminders are immutable, so it is okay for two Calendar objects to share
     * the same Reminders. But each list must have its own nodes.
     */
    public Calendar clone() {
        Calendar cloneCalendar = new Calendar();

        if (remList == null) {
            return cloneCalendar;
        }

        cloneCalendar.remList = new RemNode(remList.rem, null);
        RemNode currentThis = remList.next;
        RemNode currentClone = cloneCalendar.remList;

        while (currentThis != null) {
            RemNode newNode = new RemNode(currentThis.rem, null);
            currentClone.next = newNode;
            currentClone = newNode;
            currentThis = currentThis.next;
        }

        return cloneCalendar;
    }


    /**
     * mergeCal(Calendar cal)
     * Purpose: Merge a received parameter calendar into this calendar
     *
     * @param cal -- the calendar to be merged
     *            <p>
     *            Behavior:
     *            1. Add each reminder of the parameter Calendar to the object Calendar;
     *            may result in duplicate entries if both Calendars had the same reminders.
     *            2. All reminders that are added remain in the same order as they appeared in the
     *            parameter Calendar.
     *            3. Any added reminder with the same date of an existing reminder is added
     *            ahead of (before) the existing reminder.
     *            4. You are guaranteed that the parameter Calendar object cal is a different
     *            Calendar object than the ‘this’ Calendar object.
     *            5. The parameter cal should be unchanged after the merge. The parameter object
     *            and the 'this' object should not share any nodes. Each list must have its
     *            own nodes.
     */
    public void mergeCal(Calendar cal) {

        if (cal.remList == null) {
            return;
        }

        RemNode currentCal = cal.remList;
        while (currentCal != null) {
            RemNode newNode = new RemNode(currentCal.rem);

            if (remList == null || newNode.rem.getDate().lessthan(remList.rem.getDate())) {
                newNode.next = remList;
                remList = newNode;
                numRem++;
            } else {
                RemNode currentThis = remList;
                while (currentThis.next != null && currentThis.next.rem.getDate().lessthan(newNode.rem.getDate())) {
                    currentThis = currentThis.next;
                }
                newNode.next = currentThis.next;
                currentThis.next = newNode;
                numRem++;
            }

            currentCal = currentCal.next;
        }
    }

}
