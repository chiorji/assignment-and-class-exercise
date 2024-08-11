package bfs;

import static bfs.BFSMazeProblem.*;

public class BFSMazeProblemTest {
    public static void main(String[] args) {
        Coordinate pathCoords = traverseMaze(1, 1);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        
        while(pathCoords.getCoordinatePaths() != null){
            pathCoords = pathCoords.getCoordinatePaths();
            System.out.print(pathCoords);
        }
    }
}
