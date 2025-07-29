// File name: Repair.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 4/18/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 10
// Description: class reconstructs sentences from a string with no spaces

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Repair {
    private final Trie dictionary;

    /**
     * default constructor for Repair class
     * loads dictionary file into new Repair
     *
     * @throws FileNotFoundException If dictionary.txt can't be found in the path
     * @pre "dictionary.txt" must exist in the project directory
     * @post A new instance of Repair is created with the dictionary loaded
     */
    public Repair() throws FileNotFoundException {
        dictionary = new Trie();
        dictionary.loadFromFile("dictionary.txt");
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Sentence Reconstructor.\n");

        Repair repair = new Repair();

        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter the letters of the sentence: ");
            String input = scanner.nextLine();
            if (!isValidInput(input)) {
                System.out.println("You must enter only lowercase alphabetic characters.");
            } else {
                repair.reconstructSentence(input);
                System.out.print("Do you want to do it again? (Y|N) ");
                choice = scanner.next();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    /**
     * Validates whether input string only contains lowercase alphabetic characters
     *
     * @param input string to validate
     * @return true if the input string only contains lowercase alphabetic characters, false otherwise
     * @pre input is a non-null String
     * @post returns true if input is valid (only lowercase letters), false otherwise
     */
    public static boolean isValidInput(String input) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }

    /**
     * reconstructs all possible sentences from input String
     *
     * @param input string of letters with no spaces to reconstruct into sentences
     * @pre input should not be null or empty and must contain only lowercase alphabetic characters
     * @post All possible reconstructed sentences are printed
     */
    public void reconstructSentence(String input) {
        if (input == null || input.isEmpty()) {
            System.out.println("No input provided");
            return;
        }

        List<String> results = new ArrayList<>();
        findSentences(input, 0, "", new ArrayList<>(), results);
        for (String sentence : results) {
            System.out.println(sentence);
        }
    }

    /**
     * Recursively identifies and builds all possible sentences from a certain index
     * is a helper method used by reconstructSentence
     *
     * @param input           complete input string without spaces
     * @param index           current index in the input string being processed
     * @param currentWord     current word being formed
     * @param currentSentence list of words formed so far
     * @param results         list to store the complete sentences formed
     * @pre input is a non-null String containing only lowercase alphabetic characters
     * index, currentWord, currentSentence, and results are initialized properly
     * @post Updates results with all possible sentences that can be
     * formed from the input starting at the specified index
     */
    public void findSentences(String input, int index, String currentWord,
                              List<String> currentSentence, List<String> results) {
        if (index == input.length()) {
            if (currentWord.isEmpty()) {
                String sentence = "";
                for (int i = 0; i < currentSentence.size(); i++) {
                    sentence += currentSentence.get(i);
                    if (i < currentSentence.size() - 1) {
                        sentence += " ";
                    }
                }
                results.add(sentence);
            }
            return;
        }

        currentWord += input.charAt(index);
        if (dictionary.isPrefix(currentWord)) {
            if (dictionary.isWord(currentWord)) {
                currentSentence.add(currentWord);
                findSentences(input, index + 1, "", currentSentence, results);
                currentSentence.remove(currentSentence.size() - 1);
            }
            findSentences(input, index + 1, currentWord, currentSentence, results);
        }
    }


}
