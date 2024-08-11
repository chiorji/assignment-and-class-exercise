package bfs;

import static bfs.QueueBFSMaze.*;

public class QueueBFSMazeTest {
    public static void main(String[] args) {
        char[][] maze = new char[][]{
            {'.', '0', '0', '.', '.'},
            {'.', '.', '0', '0', '0'},
            {'0', '.', '.', '0', '.'},
            {'0', '0', '.', '.', '0'},
            {'0', '0', 'E', '.', '.'},
        };
        
        char[][] maze1 = new char[][]{
            {'.', '0', '0', '.', '.', '.', '0', '.', '.', '.'},
            {'.', '.', '0', '0', '0', '.', '0', '0', '0', '0'},
            {'0', '.', '.', '.', '.', '0', '.', '0', '0', '0'},
            {'.', '0', '0', '.', '.', '0', '0', '.', '.', '0'},
            {'0', '0', '.', '.', '0', '.', '0', '0', '0', '0'},
            {'0', '0', '0', '.', '0', '.', '.', '.', '0', '0'},
            {'.', '0', '.', '.', '0', '.', '.', '.', '0', '0'},
            {'.', '0', '0', '.', '0', '.', '.', '0', '0', '0'},
            {'0', '0', '.', 'E', '0', '.', '0', '0', '0', '0'},
            {'0', '0', '.', '.', '.', '.', '0', '0', '.', '0'},
        };
        
        printMazeGrid(maze);
        
        Direction dir = traverseMazeBFS(maze, 0, 0);
        
        while (dir.getPreviousPath() != null) {
            dir = dir.getPreviousPath();
            System.out.print("(" + dir.x + "," + dir.y + ")");
        }
        System.out.println();
        printMazeGrid(maze);
    }
}
