package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMazeProblem {
    
    /*
     * 0: unexplored spaces
     * -1: explored spaces
     * 2: maze wall
     * 3: maze path to destination
     * 9: destination
     * */
    static final int OPEN_TO_EXPLORE = 0;
    static final int EXPLORED = 1;
    static final int MAZE_WALL = 2;
    static final int MAZE_PATH = 3;
    static final int DESTINATION = 9;
    
    public static int[][] maze = new int[][]{
        {1, 1, 1, 0, 0, 0, 0, 0, 0},
        {0, 0, 1, 1, 1, 0, 1, 1, 0},
        {0, 0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 2, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 9, 0, 0, 0}
    };
    
    public static class Coordinate {
        int x;
        int y;
        Coordinate path;
        
        public Coordinate(int x, int y, Coordinate path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }
        
        public Coordinate getCoordinatePaths() {
            return this.path;
        }
        
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }
    
    public static Queue<Coordinate> coords = new LinkedList<Coordinate>();
    
    public static Coordinate traverseMaze(int x, int y) {
        Coordinate newCoord = new Coordinate(x, y, null);
        coords.add(newCoord);
        
        while (!coords.isEmpty()) {
            Coordinate trav = coords.remove();
          
            if (isValidPosition(trav.x, trav.y) && maze[trav.x][trav.y] == DESTINATION) {
                System.out.println("Yah! destination reached at coordinates (" + trav.x + "," + trav.y +")");
                return trav;
            }
            markExploreCoordinates(trav.x, trav.y);
            markCoordinateAsPath(trav.x, trav.y);
            
            if (isValidPosition(trav.x - 1, trav.y)) {
                Coordinate nextCoord = new Coordinate(trav.x - 1, trav.y, trav);
                coords.add(nextCoord);
            }
            
            if (isValidPosition(trav.x, trav.y -1)) {
                Coordinate nextCord = new Coordinate(trav.x, trav.y -1, trav);
                coords.add(nextCord);
            }
            
            if (isValidPosition(trav.x + 1, trav.y)) {
                Coordinate nextCood = new Coordinate(trav.x +1, trav.y, trav);
                coords.add(nextCood);
            }
            
            if (isValidPosition(trav.x, trav.y + 1)) {
                Coordinate nextCoord = new Coordinate(trav.x, trav.y + 1, trav);
                coords.add(nextCoord);
            }
        }
        return newCoord;
    }
    
    public static void markExploreCoordinates(int x, int y) {
        maze[x][y] = EXPLORED;
    }
    
    // Marks a given coordinate as a part of the path
    public static void markCoordinateAsPath(int x, int y) {
        maze[x][x] = MAZE_PATH;
    }
    
    /*
     * Determine if a given coordinate is valid. A valid coordinate is a point in the maze,
     * is not blocked and has not been explored
     * */
    public static boolean isValidPosition(int x, int y) {
        // Checks if cell is within bound and has not been explored or is the destination
        return ((x >= 0 && x < maze.length) && (y >= 0 && y < maze[x].length) && maze[x][y] != MAZE_WALL && (maze[x][y] == OPEN_TO_EXPLORE || maze[x][y] == DESTINATION));
    }
}

