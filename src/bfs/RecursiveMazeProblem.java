package bfs;

public class RecursiveMazeProblem {
    public static void main(String[] args) {
        char[][] maze = new char[][]{
            {'.', '.', '.', '0', '0', '0', '0', '0', '0', '0'},
            {'0', '0', '.', '.', '.', '0', '.', '.', '.', '0'},
            {'0', '0', '.', '0', '.', '0', '.', '0', '.', '0'},
            {'.', '.', '.', '0', '.', '0', '.', '0', '.', '0'},
            {'.', '0', '0', '0', '.', '.', '.', '0', '.', '0'},
            {'.', '.', '.', '.', '0', '0', '0', '.', '.', '0'},
            {'.', '0', '0', '.', '.', '.', '0', '.', '.', '0'},
            {'.', '.', '.', '0', '.', '.', '0', '0', '.', '.'},
            {'0', '0', '.', '0', '0', '.', '.', '.', '0', '0'},
            {'0', '0', '0', '0', '0', '0', '0', '.', '.', '.'}
        };
        
        printMaze(maze);
        
        if(traverseMaze(maze, 0, 0)){
            System.out.println("Solved! There's a connecting path");
        } else {
            System.out.println("Not solved! No connecting path");
        }
        
        printMaze(maze);
    }
    
    public static boolean traverseMaze(char[][] maze, int x, int y) {
        if (isValidSpot(maze, x, y)) {
            if ((x == 9 && y == 9)) {
                return true;
            }
            
            markExplored(maze, x, y);
            
            // up
            boolean trav = traverseMaze(maze, x - 1, y);
            
            // down
            if (!trav) {
                trav = traverseMaze(maze, x + 1, y);
            }
            
            // left
            if (!trav) {
                trav = traverseMaze(maze, x, y - 1);
            }
            
            // right
            if (!trav) {
                trav = traverseMaze(maze, x, y + 1);
            }
            
            if(trav){
                System.out.println(x + ", " +  y);
            }
            return trav;
        }
        return false;
    }
    
    public static boolean isValidSpot(char[][] maze, int x, int y) {
        return ((x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] == '.'));
    }
    
    public static void markExplored(char[][] maze, int x, int y) {
        maze[x][y] = '*';
    }
    
    private static void printMaze(char[][] maze) {
        System.out.println("-----------------------");
        for (int i = 0; i < maze.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------");
    }
}
