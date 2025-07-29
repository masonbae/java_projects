// File name: Calendar.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 2/8/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 2
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


    /**
     * Alt Constructor -- Create an empty collection (one with zero Reminders). Allocates 
     *      an array of the specified size to hold Reminders when they get inserted.
     * @param initSize - the size of the desired array
     * Precondition: initSize > 0; throws IllegalArgumentException if not the case
     */
    public Calendar(int initSize) {
        if (initSize <= 0) {
            throw new IllegalArgumentException("initSize must be greater than 0.");
        }
        this.remArr = new Reminder[initSize];
        this.numRem = 0;
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
     * getMaxSize -- return the size of the Reminder array
     */
    public int getMaxSize() {
        return remArr.length;
    }


    /**
     * getRem(int index)
     * <p>
     * Purpose:  returns the Reminder at the specified index in the Calendar,
     *           throw exception if index is bad.
     * @param  index - the index of the desired Reminder; using zero-based indexing
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
        return remArr[index];
    }

    
    /**
     * count(Date theDate)
     * <p>
     * Purpose: Returns the number of Reminders that occur on a specific date
     * @param theDate - the date of the Reminders we are to count
     * @return int - the number of Reminders on the specified date
     */
    public int count(Date theDate) {
        int count = 0;

        for (int i = 0; i < numRem &&
                !remArr[i].getDate().greaterthan(theDate); i++) {
            if (remArr[i].getDate().equals(theDate)) {
                count++;
            }
        }
        return count;
    }

    
    /**
     * findRem(Date theDate)
     * <p>
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
     * <p>
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
     * <p>
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
     * <p>
     * Purpose: Return a string of the reminder at a particular index in the Calendar
     * @param index -- the index of the desired reminder
     * @return string containing the reminder
     * <p>
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
     * <p>
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
     * <p>
     * Purpose: Return a string of all reminders for a given date
     * @param d -- the date we are supposed to check for matches
     * @return string containing all the matching reminders, in sorted order, each reminder
     *         followed immediately by a newline character.
     * Behavior:
     * 1. Finds all reminders on the provided date
     * 2. If no match is found, returns an empty string
     * 3. If matches are found, append them on the return string in sorted order each
     *    followed by a newline character.
     * <p>
     * Note: see addRem() for the definition of sorted order of Reminders with the
     *   same date.        
     */
    public String toString(Date d) {
        return toString(d,d);
    }

   
    /**
     * toString(Date d1, Date d2)
     * <p>
     * Purpose: Return a string of reminders in a range of two given dates
     * @param d1 & d2 -- the range of Dates
     * @return string containing all the matching reminders, in sorted order, each reminder
     *         followed immediately by a newline character.
     * <p>
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
     * <p>
     * Purpose:  compare two objects for equality
     * @param other -- an object
     * @return true if the two Calendar objects are equal, otherwise false
     * <p>
     * Behavior: Two Calendar objects are considered equal if they contain the same
     *   number of Reminders, and they contain equal Reminders in the same exact order.
     */
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (!(other instanceof Calendar))
            return false;

        Calendar otherCalendar = (Calendar) other;

        if (this.numRem != otherCalendar.numRem)
            return false;

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
     * <p>
     * Purpose: add/insert a reminder in the array of reminder objects
     * Parameters: Reminder rem - the reminder to be added
     * Returns: int - the index position of the inserted reminder
     * <p>
     * Behavior:
     * 1. In case of the array being empty: insert as the first element
     * 2. In case the array is full: double the size of the array and then add
     *     the Reminder
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
     * <p>
     * Purpose: Deletes all reminders earlier than today's date
     * @return  int - the number of Reminders deleted
     * Behavior:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     * <p>
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
     * <p>
     * Purpose: Deletes reminder object at a provided index position
     * @param index -- index of target reminder
     * @return the number of reminders deleted 
     * <p>
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
    

    /**
     * deleteRem(String str)
     * <p>
     * Purpose: Delete all reminders whose message matches a given string
     * @param str -- the message to search for (case-sensitive)
     * @return number of reminders deleted 
     * <p>
     * Notes:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     */
    public int deleteRem(String str) {
        int count = 0;
        for (int i = 0; i < numRem; ) {
            if (remArr[i].getMsg().equals(str)) {
                for (int j = i; j < numRem - 1; j++) {
                    remArr[j] = remArr[j + 1];
                }
                numRem--;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }


    /**
     * deleteRem(Reminder rem)
     * <p>
     * Purpose: Delete all occurrences of the given reminder
     * @param rem -- the reminder to be deleted
     * @return number of reminders deleted
     * <p>
     * Notes:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     */
    public int deleteRem(Reminder rem) {
        int count = 0;
        for (int i = 0; i < numRem; ) {
            if (remArr[i].equals(rem)) {
                for (int j = i; j < numRem - 1; j++) {
                    remArr[j] = remArr[j + 1];
                }
                numRem--;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }


    /**
     * deleteRem(Date d)
     * <p>
     * Purpose: Deletes all reminders on a particular date
     * @param d -- the date of reminders to be deleted
     * @return number of reminders deleted 
     * <p>
     * Notes:
     * 1) Reminders are shifted down in the array to fill any vacated entries.
     */
    public int deleteRem(Date d) {
        return deleteRem(d,d);
    }


    /**
     * deleteRem(Date d1, Date d2)
     * <p>
     * Purpose: Deletes all reminders between a range of two given dates
     * @param d1 & d2 -- the range of dates
     * @return number of reminders deleted
     * <p>
     * Behavior:
     * 1. If the Calendar contains no dates in the given range, perform no deletions &
     *     return zero
     * 2. Delete all Reminders which are later than or equal to the smaller of the two
     *     dates and are earlier than or equal to the larger of the two dates. Return the
     *     number deleted. The relative order of d1 & d2 is unknown.
     * 3. Reminders are shifted down in the array to fill any vacated entries.
     */
    public int deleteRem(Date d1, Date d2) {
        int count = 0;

        for (int i = 0; i < numRem; ) {
            Date reminderDate = remArr[i].getDate();
            boolean isAfterStart = !reminderDate.lessthan(d1) || reminderDate.equals(d1);
            boolean isBeforeEnd = !reminderDate.greaterthan(d2) || reminderDate.equals(d2);

            if (isAfterStart && isBeforeEnd) {
                for (int j = i; j < numRem - 1; j++) {
                    remArr[j] = remArr[j + 1];
                }
                numRem--;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }


    /**
     * clone() -- Return a new Calendar object that is a clone of the 'this' object.
     * The clone should have its own array (of the same size) and contain all the Reminders
     * of 'this' object.
     * Note: Reminders are immutable, so it is okay for two Calendar objects to share
     * the same Reminders.
     */
    public Calendar clone() {
        Calendar clonedCalendar = new Calendar();
        clonedCalendar.remArr = new Reminder[this.remArr.length];
        clonedCalendar.numRem = this.numRem;

        for (int i = 0; i < this.numRem; i++) {
            clonedCalendar.remArr[i] = this.remArr[i];
        }

        return clonedCalendar;

    }


    /**
     * mergeCal(Calendar cal)
     * Purpose: Merge a received parameter calendar into this calendar
     * 
     * @param cal -- the calendar to be merged
     * <p>           
     *  Behavior:
     *  1. Add each reminder of the parameter Calendar to the object Calendar;
     *     may result in duplicate entries if both Calendars had the same reminders.
     *  2. All reminders that are added remain in the same order as they appeared in the
     *     parameter Calendar.
     *  3. Any added reminder with the same date of an existing reminder is added
     *     ahead of (before) the existing reminder.
     *  4. If the total number of reminders is too big to be stored, we grow the array
     *     to a size of the total number of reminders from the two calendars plus
     *     DEFAULT_SIZE.
     *  5. The parameter cal is unchanged after the merge.
     *  6. You are guaranteed that the parameter Calendar object c is a different
     *     Calendar object than the ‘this’ Calendar object.
     * <p>
     *  Additional constraint: full credit will only be given for this function if it is
     *  efficient; that is only if each reminder is moved/assigned only once in the target
     *  array          
     */
    public void mergeCal(Calendar cal) {
        int totalReminders = this.numRem + cal.numRem;
        Reminder[] tempArr = new Reminder[totalReminders + DEFAULT_SIZE];

        int i = 0, j = 0, k = 0;

        while (i < this.numRem && j < cal.numRem) {
            if (this.remArr[i].getDate().lessthan(cal.remArr[j].getDate()) ||
                    this.remArr[i].getDate().equals(cal.remArr[j].getDate())) {
                tempArr[k++] = this.remArr[i++];
            } else {
                tempArr[k++] = cal.remArr[j++];
            }
        }

        while (i < this.numRem)
            tempArr[k++] = this.remArr[i++];
        while (j < cal.numRem)
            tempArr[k++] = cal.remArr[j++];

        this.remArr = tempArr;
        this.numRem = k;
    }


    /**
     * grow(int newSize) - grow the remArr array
     * @param newSize - the new desired size of the array
     * <p>
     * If the current size of the array is equal to or larger than newSize, we do nothing.
     * Else we allocate a new array for the Calendar of the desired size and copy the
     * old data into it. Then we have the Calendar use the new array.
     * <p>
     * NOTE: normally this method would be a private method, but it is public here to
     *       ease testing
     */
    public void grow(int newSize) {
        if (newSize > this.remArr.length) {
            Reminder[] newRemArr = new Reminder[newSize];
            for (int i = 0; i < numRem; i++) {
                newRemArr[i] = this.remArr[i];
            }
            this.remArr = newRemArr;
        }
    }


}
