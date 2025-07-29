// File name: AnimalCount.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 4/4/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 8
// Description: reads mammal data from file and determines largest family


import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintStream;
import java.util.*;


public class AnimalCount {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);

        //open data file
        Scanner infile = openInputFile(keyboard);
        PrintStream outfile = openOutputFile();

        //read in data file and produce the required report
        determineLargestMammalFamily(infile, outfile);

        // close the files
        closeFiles (infile, outfile);
    }

    
    /**
     * determineLargestMammalFamily -- 
     * Process mammal data from the inFile stream and produce report
     * to the outFile stream.
     * The report will list the largest mammal family and the members that
     * make up that family.
     * @param infile -- input stream containing mammal information
     * @param outfile -- output stream containing the final report
     * NOTE: Do not change this method header. When we grade this assignment
     * we will be calling this method with this exact name and parameter list.
     */
    public static void determineLargestMammalFamily(Scanner infile, PrintStream outfile) {
        Map<String, Set<String>> familyMap = new TreeMap<>();

        while (infile.hasNextLine()) {
            String line = infile.nextLine();
            String[] parts = line.split(" ");
            String mammal = parts[0];
            String family = parts[1];

            if (!familyMap.containsKey(family)) {
                familyMap.put(family, new TreeSet<>());
            }

            familyMap.get(family).add(mammal);
        }

        int maxFamilySize = 0;
        for (Set<String> members : familyMap.values()) {
            maxFamilySize = Math.max(maxFamilySize, members.size());
        }

        for (Map.Entry<String, Set<String>> entry : familyMap.entrySet()) {
            if (entry.getValue().size() == maxFamilySize) {
                outfile.print(entry.getKey() + " family: ");
                for (String member : entry.getValue()) {
                    outfile.print(member + " ");
                }
                outfile.println();
            }
        }
}


    /**
     * openInputFile -- open the input file
     * @param keyboard -- Scanner used to get filename
     * @return Scanner object opened on the input file
     * @throws FileNotFoundException
     */
    public static Scanner openInputFile (Scanner keyboard) throws FileNotFoundException {

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
     * openOutputFile -- open the output file
     * @return PrintStream object opened on "FamilyReport.txt"
     * @throws FileNotFoundException
     */
    public static PrintStream openOutputFile () throws FileNotFoundException {

        // open output data file
        File f2 = new File("FamilyReport.txt");
        PrintStream outfile = new PrintStream(f2);
        return outfile;
    }

    
    /**
     * closeFiles -- close the input and output files
     * @param infile -- the input file
     * @param outfile -- the output file
     */
    public static void closeFiles (Scanner infile, PrintStream outfile)  {
        infile.close();
        outfile.close();
    }


}