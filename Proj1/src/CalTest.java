// File name: CalTest
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 
// Honor statement:
// Assignment Number: 
// Description: 

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalTest {

    @Test
    public void testDefaultConstructor1() {
        Calendar cal1 = new Calendar();
        assertTrue(cal1.isEmpty());
    }

    @Test
    public void testDefaultConstructor2() {
        Calendar cal1 = new Calendar();
        assertEquals(0, cal1.getNumRem());
    }

    @Test
    public void testDefaultConstructor3() {
        Calendar cal1 = new Calendar();
        assertEquals("", cal1.toString());
    }

    @Test
    public void testIsEmptyOnNewCalendar() {
        Calendar cal = new Calendar();
        assertTrue(cal.isEmpty());
    }

    @Test
    public void testAddRemAndNumRem() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "Test Reminder"));
        assertEquals(1, cal.getNumRem());
    }

    @Test
    public void testGetRemWithValidIndex() {
        Calendar cal = new Calendar();
        Reminder rem = new Reminder(new Date(1, 1, 2024), "Test Reminder");
        cal.addRem(rem);
        assertEquals(rem, cal.getRem(0));
    }

    @Test
    public void testGetRemWithInvalidIndex() {
        Calendar cal = new Calendar();
        assertThrows(IllegalArgumentException.class, () -> cal.getRem(0));
    }

    @Test
    public void testDeletePastReminders() {
        Calendar cal = new Calendar();
        Date today = new Date();

        Date pastDate = today.plusDays(-1);
        Reminder pastReminder = new Reminder(pastDate, "Past Reminder");

        cal.addRem(pastReminder);
        cal.addRem(new Reminder(today, "Today Reminder")); // Reminder for today

        int deletedCount = cal.deleteRem();

        assertEquals(1, deletedCount);
        assertEquals(1, cal.getNumRem());
    }

    @Test
    public void testDeleteRemAtIndex() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date(1, 1, 2024), "First Reminder");
        Reminder rem2 = new Reminder(new Date(2, 1, 2024), "Second Reminder");
        cal.addRem(rem1);
        cal.addRem(rem2);
        int deletedCount = cal.deleteRem(0);
        assertEquals(1, deletedCount);
    }

    @Test
    public void testDeleteRemWithInvalidIndex() {
        Calendar cal = new Calendar();
        int deletedCount = cal.deleteRem(0);
        assertEquals(0, deletedCount);
    }

    @Test
    public void testToStringAllReminders() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date(1, 1, 2024), "New Year Reminder");
        Reminder rem2 = new Reminder(new Date(12, 25, 2023), "Christmas Reminder");
        cal.addRem(rem2);
        cal.addRem(rem1);
        String expectedOutput = rem2.toString() + "\n" + rem1.toString() + "\n";
        assertEquals(expectedOutput, cal.toString());
    }

    @Test
    public void testToStringAtIndex() {
        Calendar cal = new Calendar();
        Reminder rem = new Reminder(new Date(2, 14, 2024), "Valentine's Day");
        cal.addRem(rem);
        assertEquals(rem.toString(), cal.toString(0));
    }

    @Test
    public void testToStringOnSpecificDate() {
        Calendar cal = new Calendar();
        Date date = new Date(1, 1, 2024); // Example date
        Reminder rem = new Reminder(date, "New Year's Day");
        cal.addRem(rem);
        assertEquals(rem.toString() + "\n", cal.toString(date));
    }

    @Test
    public void testToStringDateRange() {
        Calendar cal = new Calendar();
        Date startDate = new Date(1, 1, 2024);
        Date endDate = new Date(1, 31, 2024);
        Reminder rem = new Reminder(new Date(1, 15, 2024), "Mid January Reminder");
        cal.addRem(rem);
        assertEquals(rem.toString() + "\n", cal.toString(startDate, endDate));
    }

    @Test
    public void testIsEmptyAfterDeletion() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        cal.deleteRem(0);
        assertTrue(cal.isEmpty());
    }

    @Test
    public void testGetNumRemAfterMultipleAdditions() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        cal.addRem(new Reminder(new Date(12, 25, 2023), "Christmas Reminder"));
        assertEquals(2, cal.getNumRem());
    }

    @Test
    public void testGetRemWithMultipleReminders() {
        Calendar cal = new Calendar();
        Reminder rem1 = new Reminder(new Date(1, 1, 2024), "New Year Reminder");
        Reminder rem2 = new Reminder(new Date(12, 25, 2023), "Christmas Reminder");
        cal.addRem(rem1);
        cal.addRem(rem2);
        assertEquals(rem2, cal.getRem(0));
        assertEquals(rem1, cal.getRem(1));
    }

    @Test
    public void testCountRemindersOnSameDate() {
        Calendar cal = new Calendar();
        Date date = new Date(12, 25, 2023);
        cal.addRem(new Reminder(date, "Christmas Morning"));
        cal.addRem(new Reminder(date, "Christmas Evening"));
        assertEquals(2, cal.count(date));
    }

    @Test
    public void testFindRemByNonExistentDate() {
        Calendar cal = new Calendar();
        Date date = new Date(1, 1, 2024);
        assertEquals(-1, cal.findRem(date));
    }

    @Test
    public void testFindRemByNonExistentMessage() {
        Calendar cal = new Calendar();
        String message = "Non-existent Reminder";
        assertEquals(-1, cal.findRem(message));
    }

    @Test
    public void testToStringForEmptyDateRange() {
        Calendar cal = new Calendar();
        Date startDate = new Date(12, 20, 2023);
        Date endDate = new Date(12, 24, 2023);
        assertEquals("", cal.toString(startDate, endDate));
    }

    @Test
    public void testEqualsForIdenticalCalendars() {
        Calendar cal1 = new Calendar();
        Calendar cal2 = new Calendar();
        Reminder rem = new Reminder(new Date(12, 25, 2023), "Christmas Reminder");
        cal1.addRem(rem);
        cal2.addRem(rem);
        assertTrue(cal1.equals(cal2));
    }

    @Test
    public void testAddRemToEmptyCalendar() {
        Calendar cal = new Calendar();
        Reminder rem = new Reminder(new Date(1, 1, 2024), "New Year Reminder");
        int index = cal.addRem(rem);
        assertEquals(0, index);
    }

    @Test
    public void testAddRemToFullCalendarThrowsException() {
        Calendar cal = new Calendar();
        for (int i = 0; i < Calendar.DEFAULT_SIZE; i++) {
            cal.addRem(new Reminder(new Date(1, 1, 2024), "Reminder " + (i + 1)));
        }
        assertThrows(RuntimeException.class, () ->
                cal.addRem(new Reminder(new Date(2, 1, 2024), "Overflow Reminder")));
    }

    @Test
    public void testAddRemWithInvalidDateThrowsException() {
        Calendar cal = new Calendar();
        assertThrows(IllegalArgumentException.class, () -> {
            Reminder rem = new Reminder(new Date(2, 30, 2024), "Invalid Date Reminder");
            cal.addRem(rem);
        });
    }

    @Test
    public void testEqualsForUnequalCalendars() {
        Calendar cal1 = new Calendar();
        Calendar cal2 = new Calendar();
        cal1.addRem(new Reminder(new Date(12, 25, 2023), "Christmas Reminder"));
        cal2.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        assertFalse(cal1.equals(cal2));
    }

    @Test
    public void testCountForDateWithNoReminders() {
        Calendar cal = new Calendar();
        Date date = new Date(2, 14, 2024);
        assertEquals(0, cal.count(date));
    }

    @Test
    public void testFindRemForDateWithMultipleReminders() {
        Calendar cal = new Calendar();
        Date date = new Date(12, 25, 2023); // Christmas
        cal.addRem(new Reminder(date, "Christmas Morning"));
        cal.addRem(new Reminder(date, "Christmas Evening"));
        int index = cal.findRem(date);
        assertEquals(0, index);
    }

    @Test
    public void testFindRemForExactMessage() {
        Calendar cal = new Calendar();
        String message = "Exact Message";
        cal.addRem(new Reminder(new Date(12, 25, 2023), message));
        int index = cal.findRem(message);
        assertEquals(0, index);
    }

    @Test
    public void testToStringForNoMatchingMessage() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(12, 25, 2023), "Christmas Reminder"));
        String output = cal.toString("Birthday");
        assertEquals("", output);
    }

    @Test
    public void testDeleteRemForLastIndex() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(12, 25, 2023), "First Reminder"));
        cal.addRem(new Reminder(new Date(1, 1, 2024), "Second Reminder"));
        int deletedCount = cal.deleteRem(cal.getNumRem() - 1);
        assertEquals(1, deletedCount);
        assertEquals(1, cal.getNumRem());
    }

    @Test
    public void testDeleteRemForMiddleIndex() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(12, 25, 2023), "First Reminder"));
        cal.addRem(new Reminder(new Date(12, 31, 2023), "Middle Reminder"));
        cal.addRem(new Reminder(new Date(1, 1, 2024), "Last Reminder"));
        cal.deleteRem(1);
        assertFalse(cal.toString().equals("Middle Reminder"));
    }

    @Test
    public void testEqualsForDifferentNumberOfReminders() {
        Calendar cal1 = new Calendar();
        Calendar cal2 = new Calendar();
        cal1.addRem(new Reminder(new Date(12, 25, 2023), "Christmas Reminder"));
        assertFalse(cal1.equals(cal2));
    }

    @Test
    public void testDeleteRemWithoutPastReminders() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(), "Today's Reminder"));
        int deletedCount = cal.deleteRem();
        assertEquals(0, deletedCount);
        assertEquals(1, cal.getNumRem());
    }

    @Test
    public void testToStringWithEmptyCalendar() {
        Calendar cal = new Calendar();
        assertTrue(cal.toString(0).isEmpty());
    }

    @Test
    public void testToStringWithNegativeIndex() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        assertTrue(cal.toString(-1).isEmpty());
    }

    @Test
    public void testToStringWithIndexOutOfBounds() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        assertTrue(cal.toString(1).isEmpty());
    }

    @Test
    public void testDeleteRemWithTodaysAndFutureRemindersOnly() {
        Calendar cal = new Calendar();

        cal.addRem(new Reminder(new Date(), "Today's Reminder"));
        cal.addRem(new Reminder(new Date().plusDays(1), "Tomorrow's Reminder"));
        int deletedCount = cal.deleteRem();
        assertEquals(0, deletedCount);
        assertEquals(2, cal.getNumRem());
    }

    @Test
    public void testDeleteRemWithMixedReminders() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date().plusDays(-2), "Past Reminder"));
        cal.addRem(new Reminder(new Date(), "Today's Reminder"));
        cal.addRem(new Reminder(new Date().plusDays(1), "Future Reminder"));
        int deletedCount = cal.deleteRem();

        assertEquals(1, deletedCount);
        assertEquals(2, cal.getNumRem());
    }

    @Test
    public void testToStringSingleDayRange() {
        Calendar cal = new Calendar();
        Date specificDate = new Date(4, 1, 2024);
        Reminder rem = new Reminder(specificDate, "April Fools");
        cal.addRem(rem);
        String expected = rem.toString() + "\n";
        assertEquals(expected, cal.toString(specificDate, specificDate));
    }

    @Test
    public void testToStringWithReversedDateRange() {
        Calendar cal = new Calendar();
        Date startDate = new Date(1, 20, 2024);
        Date endDate = new Date(1, 10, 2024);
        Reminder rem = new Reminder(new Date(1, 15, 2024), "Mid January Reminder");
        cal.addRem(rem);
        String expected = rem.toString() + "\n";
        assertEquals(expected, cal.toString(endDate, startDate));
    }

    @Test
    public void testIsEmptyAfterAddAndDelete() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        cal.deleteRem(0);
        assertTrue(cal.isEmpty());
    }

    @Test
    public void testGetNumRemAfterDelete() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        cal.addRem(new Reminder(new Date(2, 1, 2024), "Another Reminder"));
        cal.deleteRem(0);
        assertEquals(1, cal.getNumRem());
    }

    @Test
    public void testFindRemByFutureDate() {
        Calendar cal = new Calendar();
        Date futureDate = new Date(1, 1, 2025);
        cal.addRem(new Reminder(futureDate, "Future Reminder"));
        int index = cal.findRem(futureDate);
        assertEquals(0, index);
    }

    @Test
    public void testToStringAfterDeletingAllReminders() {
        Calendar cal = new Calendar();
        cal.addRem(new Reminder(new Date(1, 1, 2024), "New Year Reminder"));
        cal.deleteRem(0);
        assertTrue(cal.toString().isEmpty());
    }

}
