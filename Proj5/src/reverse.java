// Name: Mason Bae
// Email: mason.w.bae@vanderbilt.edu
// VUnetid: baemw
// Class: CS 2201
// Date: 3/15/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Description:
// Reverse a sound data file by reading in all the data samples,
// pushing them onto stacks, and then creating a new sound data
// file while popping values off the stacks.

import java.io.*;
import java.util.Scanner;


public class reverse {

    public static void main(String[] args) throws FileNotFoundException {

        // open input & output data files
        Scanner keyboard = new Scanner(System.in);
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile(keyboard);

        System.out.println("Reading the input file...");

        // read in the data on the first two lines of the file
        String firstLine, secondLine;

        firstLine = infile.nextLine();   // read in the first line
        secondLine = infile.nextLine();  // read in the second line

        DblStack timeSteps = new DblStack();
        DblStack soundData = new DblStack();

        int count = 0;
        while (infile.hasNextDouble()) {
            double timeStep = infile.nextDouble();
            double dataValue = infile.nextDouble();
            timeSteps.push(timeStep);
            soundData.push(dataValue);
            count++;
        }

        System.out.println("There were " + count + " samples in the file.");
        System.out.println("Creating output file... wait for Done message.");

        DblStack reversedSoundData = new DblStack();
        while (!soundData.isEmpty()) {
            reversedSoundData.push(soundData.top());
            soundData.pop();
        }

        //
        // Now we are ready to output the data values to output file.
        // But first, we need to output the header lines
        //
        outfile.println(firstLine);;
        outfile.println(secondLine);;

        while (!timeSteps.isEmpty() && !reversedSoundData.isEmpty()) {
            outfile.printf("  %14.8g\t%10.6g%n", timeSteps.top(), reversedSoundData.top());
            timeSteps.pop();
            reversedSoundData.pop();
        }

        // close the files
        infile.close();
        outfile.close();

        System.out.println("Done");
    }


    /**
     * openInputFile -- open input file
     * @param keyboard -- Scanner object to read in file name
     * @return Scanner object opened on input file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     */
    private static Scanner openInputFile (Scanner keyboard) throws FileNotFoundException {

        // open input data file
        String inFileName;
        System.out.print("Enter the name of the input file: ");
        inFileName = keyboard.nextLine();
        File f = new File(inFileName);
        while (!f.canRead()) {
            System.out.println("File not found. Try again.");
            System.out.print("Enter the name of the input file: ");
            inFileName = keyboard.nextLine();
            f = new File(inFileName);
        }
        Scanner infile = new Scanner(f);
        return infile;
    }


    /**
     * openOutputFile -- open output file
     * @param keyboard -- Scanner object to read in file name
     * @return PrintStream object opened on output file
     * @throws FileNotFoundException
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     */
    private static PrintStream openOutputFile (Scanner keyboard) throws FileNotFoundException {

        // open output data file
        String outFileName;
        System.out.print("Enter the name of the output file: ");
        outFileName = keyboard.nextLine();
        File f2 = new File(outFileName);
        PrintStream outfile = new PrintStream(f2);
        return outfile;
    }


}