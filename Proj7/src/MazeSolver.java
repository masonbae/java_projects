// File name: MazeSolver.java
// Author: Mason Bae
// userid: baemw
// Email: mason.w.bae@vanderbilt.edu
// Class: CS2201 @ Vanderbilt U.
// Assignment Number: 7
// Description:  Class that solves a maze, given the maze and an agenda.
// Last Changed: 4/1/24

public class MazeSolver {
    private Maze maze;
    private PointAgenda agenda;

    public MazeSolver(Maze newMaze, PointAgenda newAgenda) {
        this.maze = newMaze;
        this.agenda = newAgenda;
    }

    public boolean solve(boolean trace) {
        agenda.add(maze.getStartLocation());
        maze.markVisited(maze.getStartLocation());
        int visitedCount = 0;

        while (!agenda.isEmpty()) {
            Point current = agenda.peek();
            agenda.remove();
            visitedCount++;

            if (trace) {
                System.out.println(maze.toStringVisited());
            }

            if (current.equals(maze.getEndLocation())) {
                System.out.println("Solution found!");
                System.out.println("Number of nodes visited: " + visitedCount);
                return true;
            }

            checkAndAddAdjacentPoints(current);
        }

        System.out.println("Solution not found.");
        System.out.println("Number of nodes visited: " + visitedCount);
        return false;
    }

    private void checkAndAddAdjacentPoints(Point current) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // N, E, S, W
        for (int[] dir : directions) {
            Point adjacent = new Point(current.x + dir[0], current.y + dir[1]);
            if (maze.isOpen(adjacent.x, adjacent.y) && !maze.hasBeenVisited(adjacent.x, adjacent.y)) {
                agenda.add(adjacent);
                maze.markVisited(adjacent.x, adjacent.y);
            }
        }
    }
}