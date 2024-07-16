package bfs;

import static bfs.BFSMazeProblem.*;

public class BFSMazeProblemTest {
    public static void main(String[] args) {
        Coordinate coords = getCoordinatePath(0, 0);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }
        
        while(coords.getIntersection() != null){
//            System.out.print(coords);
            coords = coords.getIntersection();
        }
    }
}
