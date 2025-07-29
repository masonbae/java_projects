// File name: Calendar.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 1/26/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 1
// Description: Implementation of a Calendar class, where a Calendar is a collection
//              of Reminders kept in sorted order by Date.


public class Calendar {

    /**
     * DEFAULT_SIZE -- the default size of remArr
     */
    static final int DEFAULT_SIZE = 50;

    /**
     * numRem -- number of Reminders currently in the Calendar
     */
    private int numRem;

    /**
     * remArr -- array of Reminder objects (partially-filled)
     */
    private Reminder[] remArr;


    /**
     * Default Constructor -- Create an empty Calendar (one with zero Reminders). Allocates
     *      an array of DEFAULT_SIZE elements to hold Reminders when they get inserted.
     */
    public Calendar() {
        remArr = new Reminder[DEFAULT_SIZE];
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
     *
     * Purpose:  returns the Reminder at the specified index in the Calendar,
     *           throw exception if index is bad.
     * @param  index - the index of the desired Reminder; using zero-based indexing
     * @return Reminder - the Reminder at the specified index
     *
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
        return remArr[index];
    }


    /**
     * count(Date theDate)
     *
     * Purpose: Returns the number of Reminders that occur on a specific date
     * @param theDate - the date of the Reminders we are to count
     * @return int - the number of Reminders on the specified date
     */
    public int count(Date theDate) {
        int count = 0;

        for (int i = 0; i < numRem; i++) {
            if (remArr[i].getDate().equals(theDate)) {
                count++;
            }
        }
        return count;
    }


    /**
     * findRem(Date theDate)
     *
     * Purpose: Find first reminder for the given date and return its index
     * @param theDate -- the date to search for
     * @return int value containing the index of the first reminder with the specified date,
     *         or -1 if no reminders with that date exist
     */
    public int findRem(Date theDate) {
        for (int i = 0; i < numRem; i++) {
            if (remArr[i].getDate().equals(theDate)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * findRem(String str)
     *
     * Purpose: Find first reminder with the given message and return its index
     * @param str -- the message to search for
     * @return int value containing the index of the first reminder with the specified
     *         message, or -1 if no reminders with that message exist.
     *         String comparison is case-sensitive.
     */
    public int findRem(String str) {
        for (int i = 0; i < numRem; i++) {
            if (remArr[i].getMsg().equals(str)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * toString()
     *
     * Purpose: Return a string of all the Reminders
     * @return  String containing all the Reminders in sorted order with each & every
     *          Reminder followed immediately by a newline character.
     *          Returns an empty string if the Calendar is empty
     */
    public String toString() {
        if(numRem == 0){
            return "";
        }

        String result = "";

        for (int i = 0; i < numRem; i++) {
            result += remArr[i].toString() + "\n";
        }

        return result;
    }


    /**
     * toString(int index)
     *
     * Purpose: Return a string of the reminder at a particular index in the Calendar
     * @param index -- the index of the desired reminder
     * @return string containing the reminder
     *
     * Behavior:
     * 1. Returns string containing the reminder at the given index (no newline
     *    character added)
     * 2. Follows 0-based indexing
     * 3. If the Calendar is empty or the index is invalid, returns an empty string
     */
    public String toString(int index) {
        if(numRem == 0 || index >= numRem || index <0){
            return "";
        }

        return remArr[index].toString();
    }


    /**
     * toString(String str)
     *
     * Purpose: Return a string of all reminders whose message matches the provided string
     * @param str -- the string we are supposed to check for matches
     * @return string containing all the matching reminders, in sorted order, each reminder
     *        followed immediately by a newline character.
     * Behavior:
     * 1. Finds any reminders having its message same as the provided string (in a case-
     *    sensitive manner)
     * 2. If no match is found, returns an empty string
     * 3. If matches are found, append them on the return string in sorted order each
     *    followed by a newline character.
     */
    public String toString(String str) {
        String result = "";
        for (int i = 0; i < numRem; i++) {
            if(str.equals(remArr[i].getMsg())){
                result += remArr[i].toString() + "\n";
            }
        }
        return result;
    }


    /**
     * toString(Date d)
     *
     * Purpose: Return a string of all reminders for a given date
     * @param d -- the date we are supposed to check for matches
     * @return string containing all the matching reminders, in sorted order, each reminder
     *         followed immediately by a newline character.
     * Behavior:
     * 1. Finds all reminders on the provided date
     * 2. If no match is found, returns an empty string
     * 3. If matches are found, append them on the return string in sorted order each
     *    followed by a newline character.
     *
     * Note: see addRem() for the definition of sorted order of Reminders with the
     *   same date.
     */
    public String toString(Date d) {
        return toString(d,d);
    }


    /**
     * toString(Date d1, Date d2)
     *
     * Purpose: Return a string of reminders in a range of two given dates
     * @param d1 & d2 -- the range of Dates
     * @return string containing all the matching reminders, in sorted order, each reminder
     *         followed immediately by a newline character.
     *
     * Behavior:
     * 1. If the Calendar contains no dates in the given range, return an empty string
     * 2. Create a string containing all the reminders, in sorted order, which are later
     *    than or equal to the smaller of the two dates and are earlier than or equal to
     *    the larger of the two dates, with each reminder followed immediately by a
     *    newline character. The relative order of d1 & d2 is unknown.
     */
    public String toString(Date d1, Date d2) {
        String result = "";

        for (int i = 0; i < numRem; i++) {
            Date reminderDate = remArr[i].getDate();
            if ((!reminderDate.lessthan(d1) && !reminderDate.greaterthan(d2)) ||
                    (!reminderDate.lessthan(d2) && !reminderDate.greaterthan(d1))) {
                result += remArr[i].toString() + "\n";
            }
        }
        return result;
    }


    /**
     * equals(Object other)
     *
     * Purpose:  compare two objects for equality
     * @param other -- an object
     * @return true if the two Calendar objects are equal, otherwise false
     *
     * Behavior: Two Calendar objects are considered equal if they contain the same
     *   number of Reminders, and they contain equal Reminders in the same exact order.
     */
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Calendar)) return false;

        Calendar otherCalendar = (Calendar) other;
        if (this.numRem != otherCalendar.numRem) return false;

        for (int i = 0; i < numRem; i++) {
            if (!this.remArr[i].equals(otherCalendar.remArr[i])) {
                return false;
            }
        }
        return true;
    }


    // mutators *****************************


    /**
     * addRem(Reminder rem)
     *
     * Purpose: add/insert a reminder in the array of reminder objects
     * Parameters: Reminder rem - the reminder to be added
     * Returns: int - the index position of the inserted reminder
     *
     * Behavior:
     * 1. In case of the array being empty: insert as the first element
     * 2. In case the array is full: throw a RuntimeException exception
     * 3. In case of a non-empty array with space available: insert Reminder in sorted
     *    order, shifting other items up to make space
     * 4. In case of already existing Reminder with same date: insert new reminder
     *    before (ahead of) the existing one.
     * 5. Return the index of the inserted reminder, using zero-based indexing
     * 6. Operates in linear time.
     * Note: Normally this method would be a void method and not return any value. We have it
     * return the index of where the reminder was inserted so that we can verify that the
     * reminder was inserted in the correct position in the array.
     */
    public int addRem(Reminder rem) {
        if (numRem == DEFAULT_SIZE) {
            throw new RuntimeException("Array is full");
        }

        int index = 0;
        while (index < numRem && remArr[index].getDate().lessthan(rem.getDate())) {
            index++;
        }

        for (int j = numRem; j > index; j--) {
            remArr[j] = remArr[j - 1];
        }

        remArr[index] = rem;
        numRem++;

        return index;
    }


    /**
     * deleteRem()
     *
     * Purpose: Deletes all reminders earlier than today's date
     * @return  int - the number of Reminders deleted
     * Behavior:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     *
     * Implementation Notes:
     * 1) The default constructor of the Date class initializes a Date object to today's
     *    date.
     */
    public int deleteRem() {
        Date today = new Date();
        int count = 0;

        while (numRem > 0 && remArr[0].getDate().lessthan(today)) {
            for (int i = 1; i < numRem; i++) {
                remArr[i - 1] = remArr[i];
            }
            remArr[numRem - 1] = null;
            numRem--;
            count++;
        }
        return count;
    }


    /**
     * deleteRem(int index)
     *
     * Purpose: Deletes reminder object at a provided index position
     * @param index -- index of target reminder
     * @return the number of reminders deleted
     *
     * Notes:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     * 2) If the index is invalid, no deletions will be performed and zero is returned
     */
    public int deleteRem(int index) {
        if (index < 0 || index >= numRem) {
            return 0;
        }

        for (int i = index; i < numRem - 1; i++) {
            remArr[i] = remArr[i + 1];
        }

        numRem--;
        return 1;
    }


}
