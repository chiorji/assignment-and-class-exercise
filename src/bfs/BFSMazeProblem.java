package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSMazeProblem {
    
    /*
    * 0: unexplored spaces
    * -1: explored spaces
    * 2: maze wall
    * 3: destination
    * */
    public static int[][] maze = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {2, 2, 2, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 2, 0, 0, 0, 0},
        {0, 0, 2, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 2, 2, 0, 0, 0, 0, 0},
        {0, 0, 0, 2, 0, 0, 0, 0, 3}
    };
    
    public static class Coordinate {
        int x;
        int y;
        Coordinate intersection;
        
        public Coordinate(int x, int y, Coordinate intersection) {
            this.x = x;
            this.y = y;
            this.intersection = intersection;
        }
        
        public Coordinate getIntersection() {
            return this.intersection;
        }
    }
    
    public static Queue<Coordinate> coords = new LinkedList<Coordinate>();
    
    public static Coordinate getCoordinatePath(int x, int y) {
        Coordinate newCoord = new Coordinate(x, y, null);
        coords.add(newCoord);
        
        while (!coords.isEmpty()) {
            Coordinate coord = coords.poll();
            
            if (maze[coord.x][coord.y] == 3) {
                System.out.println("Yah! destination reached.");
                return coord;
            }
            
            if (isFreeSpace(coord.x + 1, coord.y)) {
                maze[coord.x][coord.y] = -1;
                Coordinate nextCoord = new Coordinate(coord.x + 1, coord.y, coord);
                coords.add(nextCoord);
            }
            
            if (isFreeSpace(coord.x - 1, coord.y)) {
                maze[coord.x][coord.y] = -1;
                Coordinate nextCord = new Coordinate(coord.x - 1, coord.y, coord);
                coords.add(nextCord);
            }
            
            if (isFreeSpace(coord.x, coord.y + 1)) {
                maze[coord.x][coord.y] = -1;
                Coordinate nextCood = new Coordinate(coord.x, coord.y + 1, coord);
                coords.add(nextCood);
            }
            
            if (isFreeSpace(coord.x, coord.y - 1)) {
                maze[coord.x][coord.y] = -1;
                Coordinate nextCoord = new Coordinate(coord.x, coord.y - 1, coord);
                coords.add(nextCoord);
            }
        }
        return newCoord;
    }
    
    public static boolean isFreeSpace(int x, int y) {
        return ((x >= 0 && x < maze.length) && (y >= 0 && y < maze.length) && (maze[x][y] == 0 || maze[x][y] == 3));
    }
}

