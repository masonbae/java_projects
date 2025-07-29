// File name: CalDemo.java
// Author: 
// VUnetid: 
// Email: 
// Class: CS2201
// Date: 
// Honor statement:
// Assignment Number: 
// Description: An executable program to try things with the Calendar class


public class CalDemo {
    public static void main(String[] args) {
        
        Date today = new Date();
        Date tomorrow = today.plusDays(+1);
        System.out.println("Today is " + today + ", and tomorrow is " + tomorrow);

        Calendar cal1 = new Calendar();
        
        Reminder rem = new Reminder("1/8/2024", "First day of classes");
        int index = cal1.addRem(rem);

        if (index != 0) {
            System.out.println("insert failed to return index 0 for first insertion");
            System.out.println("Returned index == " + index);
        }

        rem = new Reminder("2/7/2024", "Exam #1");
        cal1.addRem(rem);
        rem = new Reminder("4/26/2024", "Final Exam");
        cal1.addRem(rem);
        
        System.out.println("My important dates:\n" + cal1);
        
        Date newYearsEve = new Date("12/31/2024");
        
        System.out.println("Those items that are between today and the end of the year:");
        System.out.println(cal1.toString(today,newYearsEve));



        // Here is an example of using a try-catch block to test exception throwing.
        // You place your code that should generate an exception in the "try" block, and you
        // specify the exception you are catching in the "catch" expression. If an exception is
        // thrown, control will branch immediately to the "catch" block. If an exception is not
        // thrown, the "try" block will fully execute and then control goes to whatever follows
        // the try-catch block.
        // Experiment: change the number of iterations of the loop and observe the behavior.
        // Try 10 & 100.
        try {
            for (int i = 0; i < 100; i++) { // attempt to insert 100 reminders (max was 50)
                cal1.addRem(rem);
            }
            System.out.println("\nTHIS MESSAGE SHOULD NOT BE SEEN."
                    + "\nA RuntimeException was not thrown!!");
        }
        catch (RuntimeException excpt) {
            System.out.println("Exception successfully thrown & caught:: " + excpt.getMessage());
        }
  
    }
}