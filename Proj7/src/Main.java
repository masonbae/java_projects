// File name: Main.java
// Author: CS2201 Instructor
// userid:
// Email:
// Class: CS2201 @ Vanderbilt U.
// Assignment Number:
// Description:  Determine if a maze has a solution (and print a trace).
//    A basic exercise for stacks and queues (or any agenda-type container).
// Last Changed:  8-2-2023

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String choice;
        String filename;
        Scanner keyboard = new Scanner(System.in);

        System.out.println("MAZE SOLVER!!\n");

        do {
            System.out.print("Please enter name of file containing the maze: ");
            filename = keyboard.nextLine();
            Maze newMaze = new Maze(filename);

            System.out.println("Here is the maze to be solved:\n" + newMaze.toString());

            PointAgenda myAgenda = chooseAgenda(keyboard);

            MazeSolver solver = new MazeSolver(newMaze, myAgenda);

            System.out.println("\nDo you want to trace the execution of the solver? (Y|N)");
            choice = keyboard.nextLine().toUpperCase();
            System.out.println();
            boolean trace = choice.charAt(0)=='Y';

            solver.solve(trace);

            System.out.println("\nDo you want to solve another maze? (Y|N)");
            choice = keyboard.nextLine().toUpperCase();
        } while(choice.charAt(0)=='Y');
    }


    // chooseAgenda() function
    // Prompts the user for the desired agenda type,
    // instantiates such an agenda via new, and returns it.
    public static PointAgenda chooseAgenda(Scanner keyboard) {
        int choice = 0;

        do {
            System.out.println("\nPlease select the type of agenda you want to use " +
                    "by entering its number:");
            System.out.println("1: Stack-based agenda");
            System.out.println("2: Queue-based agenda");
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
            keyboard.nextLine(); // consume the rest of the input line
            if (choice<1 || choice>2) {
                System.out.println("Invalid choice. Try again.");
            }
        } while (choice<1 || choice>2);

        switch (choice) {
            case 1:
                System.out.println("\nSolving the maze with a stack-based agenda:");
                return new LifoPointAgenda();
            case 2:
                System.out.println("\nSolving the maze with a queue-based agenda:");
                return new FifoPointAgenda();
            default:
                throw new RuntimeException("Internal error on choosing an agenda type.");
        }
    }

}