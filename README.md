# Data Structures Class Projects 

This repository contains all programming assignments completed for CS2201 Data Structures at Vanderbilt University.

## Author
- **Name:** Mason Bae
- **Email:** mason.w.bae@vanderbilt.edu

## Project Overview

### Project 1: Calendar Application
A calendar management system using arrays to store and organize reminders.
- **Key Concepts:** Arrays, Sorting, Object-Oriented Programming
- **Features:**
  - Add/remove reminders with dates
  - Sort reminders chronologically
  - Search for reminders by date
  - Partially-filled array implementation

### Project 2: Enhanced Calendar
An improved version of the calendar with additional functionality.
- **Key Concepts:** Dynamic Arrays, Advanced Sorting
- **Features:**
  - Extended reminder management
  - Improved date handling
  - Enhanced search capabilities

### Project 3: Calendar with Advanced Features
Further enhancements to the calendar system.
- **Key Concepts:** Complex Data Management, Algorithm Optimization
- **Features:**
  - Additional calendar operations
  - Performance improvements
  - Extended test coverage

### Project 4: Recursive Programming
Implementation of various recursive algorithms.
- **Key Concepts:** Recursion, Divide and Conquer
- **Features:**
  - Multiple recursive function implementations
  - No loops allowed (pure recursion)
  - Comprehensive test suite

### Project 5: Double Stack Implementation
Implementation of a stack data structure for double values using linked lists.
- **Key Concepts:** Stacks, Linked Lists, LIFO
- **Features:**
  - Push/pop operations
  - Peek functionality
  - Size tracking
  - Expression evaluation using stacks

### Project 6: Double Queue & Guitar Hero Simulation
Implementation of a queue data structure and its application in sound synthesis.
- **Key Concepts:** Queues, Linked Lists, FIFO, Sound Synthesis
- **Features:**
  - Enqueue/dequeue operations
  - Guitar string simulation using Karplus-Strong algorithm
  - Interactive guitar playing application

### Project 7: Maze Solver
A maze-solving application using different traversal strategies.
- **Key Concepts:** Stack/Queue Applications, Graph Traversal, DFS/BFS
- **Features:**
  - LIFO (Stack-based) maze solving - Depth-First Search
  - FIFO (Queue-based) maze solving - Breadth-First Search
  - Visual maze representation
  - Path finding algorithms

### Project 8: Animal Count - HashMap Application
Analysis of mammal families using Java's HashMap.
- **Key Concepts:** HashMaps, File I/O, Data Analysis
- **Features:**
  - Read mammal data from files
  - Count species per family
  - Determine largest mammal family
  - File input/output handling

### Project 9: Trie Data Structure
Implementation of a Trie (prefix tree) for efficient word storage and retrieval.
- **Key Concepts:** Tries, Tree Structures, String Processing
- **Features:**
  - Word insertion and search
  - Prefix matching
  - Dictionary loading from file
  - Comprehensive testing suite

### Project 10: Sentence Repair Using Trie
Application of Trie data structure to reconstruct sentences from strings without spaces.
- **Key Concepts:** Dynamic Programming, Trie Applications, String Reconstruction
- **Features:**
  - Reconstruct sentences from concatenated words
  - Dictionary-based word validation
  - Efficient string segmentation
  - Real-world application of Tries

## Technologies Used
- **Language:** Java
- **Development Environment:** IntelliJ IDEA (based on .iml files)
- **Testing:** Self-written comprehensive test suites for most projects

## How to Run

Each project is contained in its own directory with source files in the `src/` folder.

1. Navigate to the specific project directory
2. Compile the Java files:
   ```bash
   javac src/*.java
   ```
3. Run the main class or demo file:
   ```bash
   java -cp src [MainClassName]
   ```

For example:
- Projects 1-3: `java -cp src CalDemo`
- Project 4: `java -cp src Project4Demo`
- Project 5: `java -cp src reverse`
- Project 6: `java -cp src GuitarHero`
- Project 7: `java -cp src Main`
- Project 8: `java -cp src AnimalCount`
- Projects 9-10: Run the test files or integrate with your own code

## Testing

I wrote comprehensive test suites for most projects to ensure correctness and robustness:
- `CalTest.java` for Projects 1-3 - Extensive testing of calendar operations
- `Project4Test.java` for Project 4 - Tests for all recursive functions
- `DblStackTest.java` for Project 5 - Stack operation edge cases
- `DblQueueTest.java` and `GuitarStringTest.java` for Project 6 - Queue operations and sound synthesis
- `TrieTest.java` for Project 9 - Trie insertion, search, and edge cases

Run tests using:
```bash
java -cp src [TestClassName]
```

## Learning Outcomes

Through these projects, I gained hands-on experience with:
- Fundamental data structures (Arrays, Linked Lists, Stacks, Queues, Trees, Tries)
- Algorithm design and analysis
- Recursive programming techniques
- Object-oriented design principles
- File I/O and data processing
- Real-world applications of data structures
- Test-driven development and writing comprehensive test suites
- Debugging and edge case identification through self-written tests

## Honor Code

All projects were completed in accordance with Vanderbilt's Honor Code. Each source file includes an honor statement attesting that no unauthorized aid was given or received.
