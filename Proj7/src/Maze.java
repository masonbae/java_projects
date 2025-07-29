// File name: Maze.java
// Author: CS2201 Instructor
// userid:
// Email:
// Class: CS2201 @ Vanderbilt U.
// Assignment Number:
// Description:  Class implementation that represents a maze.
//    A maze has walls, open locations, a start location, and an end location.
//    The initial maze is read from a file. See problem spec for file format.
//    Once the maze has been read from the file, it cannot be changed.
//    The user can get a location from the maze, and keep track of which locations
//    have been visited. Locations are represented by x-y coordinates or Point objects.
//    The origin (0,0) is the lower left corner of the graph; the x-coordinate moves
//    left to right across the x axis; the y-coordinate moves bottom to top up the y axis.
// Last Changed:  8/2/2023


import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Maze {

    // class constants
    public final char WALL='#';
    public final char OPEN=' ';
    public final char START='o';
    public final char END='*';
    public final int MAX_ROWS = 80;
    public final int MAX_COLS = 80;

    // we implement the Maze as an array of Strings
    private String[] myMaze;

    // height and width of the maze
    private int numRows;
    private int numCols;

    // keep track of visited points with a boolean matrix
    private boolean visited[][];

    // Start and end locations of the maze
    private Point startLocation;
    private Point endLocation;


    // Constructor
    // Accepts file name as a parameter
    // Reads the file and initializes start and end location and myMaze matrix and visited matrix
    public Maze (String filename) throws FileNotFoundException {

        String str;

        Scanner file = new Scanner(new File(filename));

        Point doesNotExist = new Point(-1,-1);
        startLocation = doesNotExist;
        endLocation = doesNotExist;

        // file starts with number of rows & cols; read them in
        numRows = file.nextInt();
        numCols = file.nextInt();
        file.nextLine();  // consume rest of first line

        if (numRows<0 || numRows>MAX_ROWS || numCols<0 || numCols>MAX_COLS) {
            throw new RuntimeException("File contains invalid size specification for the Maze.");
        }

        myMaze = new String[numRows];
        visited = new boolean[numCols][numRows];

        int y=numRows-1;
        while( file.hasNextLine() )
        {
            str = file.nextLine();
            if (str.length()!=numCols) {
                System.out.println("File contained a line with incorrect number of characters");
                System.out.println("Ignoring this line: " + str);
                System.out.println("Row = " + y);
                continue;
            }

            myMaze[y] = str;   // set the row of the maze
            // look for start and end locations
            for(int x=0; x<numCols; x++)
            {
                if(str.charAt(x)==START) {  // if this is the start...
                    startLocation = new Point(x,y);
                }
                else if(str.charAt(x)==END) {  // if this is the end...
                    endLocation = new Point(x,y);
                }
            }
            y--;
            if(y<0)
                break;
        }
        if (y != -1) {
            throw new RuntimeException("File did not contain the correct number of rows.");
        }

        resetVisitedFlags();   // init the visited matrix

        file.close();
    }

    // toString
    // convert Maze to a string representation
    public String toString() {
        String result = "";

        for(int y=numRows-1; y>=0; y--)
        {
            result += myMaze[y] + "\n";
        }

        return result;
    }


    // toStringVisited
    // convert visited Maze to a string representation with visited locations marked by a 'V'
    public String toStringVisited() {
        String result = "";

        for(int y=numRows-1; y>=0; y--) {
            for(int x=0; x<numCols; x++) {
                if (isOpen(x,y) && hasBeenVisited(x,y)) {
                    result += "V";
                } else {
                    result += myMaze[y].charAt(x);
                }
            }
            result += "\n";
        }

        return result;
    }


    // Get the maze dimensions
    public int getNumRows() {
        return numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    // Private helper function to insure row & col are within the maze
    private void checkRange(int x, int y) {
        if(y<0 || y>=this.numRows || x<0 || x>=this.numCols) {
            throw new RuntimeException("Maze:: Index (" + x + "," + y + ") is out of range");
        }
    }


    // Get an item at the given coodinates from the maze matrix.
    // Throws RuntimeException if the coordinates are not within the maze bounds
    public char get (int x, int y) {
        checkRange(x, y);
        return myMaze[y].charAt(x);
    }

    public char get (Point location) {
        return get(location.x, location.y);
    }


    // Set visited flag in the visited matrix at the given coodinates.
    // Throws RuntimeException if the coordinates are not within the maze bounds
    public void markVisited (int x, int y) {
        checkRange(x, y);
        visited[x][y] = true;
    }

    public void markVisited (Point location) {
        markVisited(location.x, location.y);
    }


    // Get visited flag at the given coordinates from the visited matrix.
    // Throws RuntimeException if the coordinates are not within the maze bounds
    public boolean hasBeenVisited (int x, int y) {
        checkRange(x, y);
        return visited[x][y];
    }

    public boolean hasBeenVisited (Point location) {
        return hasBeenVisited(location.x, location.y);
    }


    // Determine if the given coordinates is an open location
    // Throws RuntimeException if the coordinates are not within the maze bounds
    public boolean isOpen (int x, int y) {
        return !isWall(x,y);
    }

    public boolean isOpen (Point location) {
        return isOpen(location.x, location.y);
    }

    // Determine if the given coordinates is a wall location
    // Throws RuntimeException if the coordinates are not within the maze bounds
    public boolean isWall (int x, int y) {
        return (get(x,y)==WALL);
    }

    public boolean isWall (Point location) {
        return isWall(location.x, location.y);
    }


    //resetVisited
    //Reset boolean visited Matrix
    public void resetVisitedFlags() {
        for(int x=0; x<numCols; x++) {
            for(int y=0; y<numRows; y++) {
                visited[x][y]=false;
            }
        }
    }


    // Get the start and end locations
    public Point getStartLocation() {
        return startLocation;
    }

    public Point getEndLocation() {
        return endLocation;
    }

}
