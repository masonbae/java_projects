// File name: Trie.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 4/10/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 9
// Description: holds collection of words in trie

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ', false);
    }

    public void insert(String word) {
        root.insert(word);
    }

    public void loadFromFile(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase();
            insert(word);
        }
        scanner.close();
    }

    public boolean isWord(String word) {
        return root.isWord(word);
    }

    public boolean isPrefix(String prefix) {
        return root.isPrefix(prefix);
    }

    public String toString() {
        return root.toString("");
    }

    public int wordCount() {
        return root.wordCount();
    }

    public Trie clone() {
        Trie clone = new Trie();
        clone.root = this.root.clone();
        return clone;
    }

    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;

        Trie otherTrie = (Trie) other;
        return root.equals(otherTrie.root);
    }

}
