# Data Structures Projects - CS2201

This repository contains 10 programming projects completed for CS2201 (Data Structures) at Vanderbilt University. Each project focuses on implementing and working with different data structures and algorithms.

## Author
**Mason Bae** (baemw)  
mason.w.bae@vanderbilt.edu

---

## Project Overview

### Project 1: Calendar with Array Implementation
**Directory:** `Proj1/`  
**Key Files:** `Calendar.java`, `Date.java`, `Reminder.java`

Implements a calendar system using a **partially-filled array** to store reminders in sorted order by date. Features include:
- Adding/removing reminders
- Searching for reminders by date
- Maintaining chronological order
- Custom Date and Reminder classes

**Data Structures:** Arrays, Custom Objects

---

### Project 2: Enhanced Calendar System
**Directory:** `Proj2/`  
**Key Files:** `Calendar.java`, `Date.java`, `Reminder.java`

An enhanced version of Project 1 with additional functionality and improved implementation of the calendar system. Builds upon the array-based approach with more robust operations.

**Data Structures:** Arrays, Custom Objects

---

### Project 3: Advanced Calendar Features
**Directory:** `Proj3/`  
**Key Files:** `Calendar.java`, `Date.java`, `Reminder.java`

Further extension of the calendar system with additional methods and enhanced functionality, demonstrating progressive development of the same core data structure.

**Data Structures:** Arrays, Custom Objects

---

### Project 4: Recursive Programming
**Directory:** `Proj4/`  
**Key Files:** `Project4.java`

Collection of **recursive algorithms** implementing various computational problems without using loops. Includes functions for:
- Array operations (sum, search, membership)
- Mathematical computations
- String processing
- Set operations

**Focus:** Recursion, Algorithm Design

---

### Project 5: Stack Implementation and Audio Processing
**Directory:** `Proj5/`  
**Key Files:** `DblStack.java`, `reverse.java`

Implements a **linked list-based stack** for double values and uses it to reverse audio files:
- Custom stack implementation using nodes
- Audio file processing application
- LIFO (Last In, First Out) operations

**Data Structures:** Linked Lists, Stacks

---

### Project 6: Guitar Hero Simulation with Queues
**Directory:** `Proj6/`  
**Key Files:** `GuitarHero.java`, `GuitarString.java`, `DblQueue.java`

Simulates guitar string vibrations using **circular queues** (ring buffers):
- Karplus-Strong algorithm for string synthesis
- 37 guitar strings (3 octaves)
- Audio output generation
- Queue-based sound wave simulation

**Data Structures:** Circular Queues, Arrays

---

### Project 7: Maze Solver with Stack and Queue
**Directory:** `Proj7/`  
**Key Files:** `Maze.java`, `MazeSolver.java`, `Stack.java`, `Queue.java`, `Point.java`

Maze-solving application demonstrating different search strategies:
- **Depth-First Search** using stacks (LIFO)
- **Breadth-First Search** using queues (FIFO)
- Custom stack and queue implementations
- Point-based coordinate system

**Data Structures:** Stacks, Queues, Custom Classes

---

### Project 8: Animal Classification with Maps
**Directory:** `Proj8/`  
**Key Files:** `AnimalCount.java`

Processes mammal data to find the largest family using **Java Collections**:
- TreeMap for sorted family storage
- Set operations for unique species tracking
- File I/O for data processing
- Statistical analysis of biological data

**Data Structures:** Maps (TreeMap), Sets

---

### Project 9: Trie Data Structure
**Directory:** `Proj9/`  
**Key Files:** `Trie.java`, `TrieNode.java`  
**Test Files:** `test.txt`, `test2.txt`, `testDuplicates.txt`

Implements a **trie (prefix tree)** for efficient string storage and retrieval:
- Word insertion and lookup
- Prefix checking
- File-based dictionary loading
- Tree traversal and word counting

**Data Structures:** Trees (Trie), Recursive Data Structures

---

### Project 10: Sentence Reconstruction
**Directory:** `proj10/`  
**Key Files:** `Repair.java`, `Trie.java`, `TrieNode.java`

Uses the trie data structure to reconstruct sentences from strings without spaces:
- Dictionary-based word validation
- Recursive sentence parsing
- Multiple solution generation
- Dynamic programming approach

**Data Structures:** Trees (Trie), Dynamic Programming

---

## Key Learning Outcomes

Throughout these projects, the following concepts were explored:

### Data Structures Implemented:
- **Arrays** (static and dynamic)
- **Linked Lists** (singly-linked)
- **Stacks** (array and linked-list based)
- **Queues** (circular/ring buffer implementation)
- **Trees** (Trie/prefix tree)
- **Maps and Sets** (Java Collections Framework)

### Algorithms and Techniques:
- **Recursion** (various recursive problems)
- **Search Algorithms** (DFS, BFS)
- **Sorting** (maintaining sorted order)
- **String Processing** (pattern matching, reconstruction)
- **Audio Processing** (digital signal processing)
- **File I/O** (reading/writing various formats)

### Programming Concepts:
- Object-oriented design
- Custom class implementation
- Exception handling
- Testing and validation
- Code documentation and style

---

## How to Run

Each project is self-contained with its own source files. To run any project:

1. Navigate to the project directory (e.g., `cd Proj1`)
2. Compile the Java files: `javac src/*.java`
3. Run the main class: `java -cp src [MainClassName]`

Some projects may require input files or user interaction as specified in their individual implementations.

---

## Academic Integrity

All projects were completed in accordance with Vanderbilt University's honor code. Each file includes an honor statement attesting to original work and proper attribution of any assistance received.