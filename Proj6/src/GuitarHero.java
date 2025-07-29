// File name: GuitarHero.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Honor Statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 6
// Description: GuitarHero class that creates guitar octaves using GuitarString class
// Last Changed: 3/24/24
//

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;


public class GuitarHero {

    public static final double CONCERT_A = 440.0;
    public static final int NUM_STRINGS = 37;
    public static final double STEP = (double) 1 / ((double) GuitarString.SAMPLE_RATE);
    public static final int END_OF_SONG = -1;


    public static void main(String[] args) throws FileNotFoundException {

        // create the array of guitar strings (3 octaves)
        GuitarString[] strings = new GuitarString[NUM_STRINGS];
        createStrings(strings);

        //open data file
        Scanner keyboard = new Scanner(System.in);
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile(keyboard);

        //prime the output file
        String firstLine = "; Sample Rate " + GuitarString.SAMPLE_RATE;
        String secondLine = "; Channels 1";
        outfile.println(firstLine);
        outfile.println(secondLine);

        System.out.println("Reading the input file and generating a .dat file for sox");

        double currentTime = 0;
        double lastTime = -1;

        while (infile.hasNext()) {
            double eventTime = readAndValidateTime(infile, lastTime);
            int stringIndex = readAndValidateStringIndex(infile);

            while (currentTime < eventTime) {
                processTimestep(strings, outfile);
                currentTime += STEP;
            }

            if (stringIndex != END_OF_SONG) {
                strings[stringIndex].pluck();
            } else {
                break;
            }
            lastTime = eventTime;
        }

        // close the files
        infile.close();
        outfile.close();

        System.out.println("Done.");
    }

    private static double readAndValidateTime(Scanner infile, double lastTime) {
        if (!infile.hasNextDouble()) throw new RuntimeException
                ("Expected a time value but reached end of file.");
        double time = infile.nextDouble();
        if (time < 0 || time < lastTime) {
            throw new RuntimeException("Invalid time value: " + time);
        }
        return time;
    }

    private static int readAndValidateStringIndex(Scanner infile) {
        if (!infile.hasNextInt()) throw new RuntimeException
                ("Expected a string index but reached end of file.");
        int index = infile.nextInt();
        if (index < END_OF_SONG || index >= NUM_STRINGS) {
            throw new RuntimeException("Invalid string index: " + index);
        }
        return index;
    }

    private static void processTimestep(GuitarString[] strings, PrintStream outfile) {
        double sample = 0;
        for (GuitarString string : strings) {
            sample += string.sample();
            string.tic();
        }
        outfile.println(sample);
    }


    /**
     * createStrings -- create the guitar string objects
     * post: array of GuitarString objects have been created and initialized
     *
     * @param strings
     */
    private static void createStrings(GuitarString[] strings) {
        for (int i = 0; i < strings.length; i++) {
            double factor = Math.pow(2.0, (i - 24) / 12.0);
            strings[i] = new GuitarString(CONCERT_A * factor);
        }
    }


    /**
     * openInputFile
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     *
     * @param keyboard -- opened Scanner object
     * @return Scanner object opened on input file
     * @throws FileNotFoundException
     */
    private static Scanner openInputFile(Scanner keyboard) throws FileNotFoundException {

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
     * openOutputFile
     * pre: user is prepared to enter file name at the keyboard
     * post: file have been opened
     *
     * @param keyboard -- opened Scanner object
     * @return PrintStream object opened on output file
     * @throws FileNotFoundException
     */
    private static PrintStream openOutputFile(Scanner keyboard) throws FileNotFoundException {

        // open output data file
        String outFileName;
        System.out.print("Enter the name of the output file: ");
        outFileName = keyboard.nextLine();
        File f2 = new File(outFileName);
        PrintStream outfile = new PrintStream(f2);
        return outfile;
    }

}
