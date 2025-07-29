// File name: TrieNode.java
// Author: Mason Bae
// VUnetid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201
// Date: 4/10/24
// Honor statement: I attest that I understand the honor code for this class and have neither
// given nor received any unauthorized aid on this assignment.
// Assignment Number: 9
// Description: provides support for one node in the trie tree

public class TrieNode {
    private static final int ALPHABET_SIZE = 26;
    private TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    private char letter;
    private boolean isEndOfWord;

    public TrieNode(char letter, boolean flag) {
        this.letter = letter;
        this.isEndOfWord = flag;
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            children[i] = null;
        }
    }

    public void insert(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(word.charAt(i), false);
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean isWord(String word) {
        TrieNode current = this;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public boolean isPrefix(String prefix) {
        TrieNode current = this;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return true;
    }

    public String toString(String pre) {
        String result = "";
        if (isEndOfWord) {
            result += pre + "\n";
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (children[i] != null) {
                result += children[i].toString(pre + children[i].letter);
            }
        }
        return result;
    }

    public int wordCount() {
        int count = 0;
        if (isEndOfWord) {
            count = 1;
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (children[i] != null) {
                count += children[i].wordCount();
            }
        }
        return count;
    }

    public TrieNode clone() {
        TrieNode clonedNode = new TrieNode(this.letter, this.isEndOfWord);
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (this.children[i] != null) {
                clonedNode.children[i] = this.children[i].clone();
            }
        }
        return clonedNode;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        TrieNode other = (TrieNode) obj;
        if (isEndOfWord != other.isEndOfWord) return false;

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if ((children[i] == null && other.children[i] != null) ||
                    (children[i] != null && !children[i].equals(other.children[i]))) {
                return false;
            }
        }
        return true;
    }
}
