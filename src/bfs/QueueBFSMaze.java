package bfs;

import java.util.*;

public class QueueBFSMaze {
    final static char EXPLORABLE_PATH = '.';
    final static char EXPLORED_PATH = '*';
    final static char DESTINATION = 'E';
    
    public static class Direction {
        int x, y;
        Direction previousPath;
        
        public Direction(int x, int y, Direction previousPath) {
            this.x = x;
            this.y = y;
            this.previousPath = previousPath;
        }
        
        public Direction getPreviousPath() {
            return this.previousPath;
        }
    }
    
    public static Queue<Direction> directions = new LinkedList<>();
    
    public static Direction traverseMazeBFS(char[][] maze, int x, int y) {
        Direction points = new Direction(x, y, null);
        Direction nextPoints;
        
        directions.add(points);
        
        while (!directions.isEmpty()) {
            Direction path = directions.remove();
            
            if (isValidSpot(maze, path.x, path.y) && maze[path.x][path.y] == DESTINATION) {
                markExploredPath(maze, path.x, path.y);
                System.out.println("SOLVED!");
                return path;
            }
            
            // check if adjacent right point is valid and move right on the x-axis
            if (isValidSpot(maze, path.x + 1, path.y)) {
                markExploredPath(maze, x + 1, y);
                nextPoints = new Direction(path.x + 1, path.y, path);
                directions.add(nextPoints);
            }
            
            // check if adjacent left point is valid and move left on the x-axis
            if (isValidSpot(maze, path.x - 1, y)) {
                markExploredPath(maze, path.x - 1, y);
                nextPoints = new Direction(path.x - 1, y, path);
                directions.add(nextPoints);
            }
            
            // check if adjacent up point is valid and move up on the y-axis
            if (isValidSpot(maze, path.x, path.y - 1)) {
                markExploredPath(maze, path.x, path.y - 1);
                nextPoints = new Direction(path.x, path.y - 1, path);
                directions.add(nextPoints);
            }
            
            // check if adjacent point is valid and move down on the y-axis
            if (isValidSpot(maze, path.x, path.y + 1)) {
                markExploredPath(maze, path.x, path.y + 1);
                nextPoints = new Direction(path.x, path.y + 1, path);
                directions.add(nextPoints);
            }
        }
        
        return points;
    }
    
    private static boolean isValidSpot(char[][] maze, int x, int y) {
        return ((x >= 0 && x < maze.length) && (y >= 0 && y < maze[x].length) && (maze[x][y] == EXPLORABLE_PATH || maze[x][y] == DESTINATION));
    }
    
    private static void markExploredPath(char[][] maze, int x, int y) {
        maze[x][y] = EXPLORED_PATH;
    }
    
    private static int getLastRowIndex(char[][] maze){
        return maze.length - 1;
    }
    
    private static int getLastColumnIndex(char[][] maze, int x){
        return maze[x].length - 1;
    }
    
    public static void printMazeGrid(char[][] maze) {
        String border = "-".repeat((maze.length) * 2 + 3);
        System.out.println(border);
        int x, y;
        for (x = 0; x < maze.length; x++) {
            System.out.print("| ");
            for (y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y] + " ");
            }
            System.out.println("|");
        }
        System.out.println(border);
    }
}
