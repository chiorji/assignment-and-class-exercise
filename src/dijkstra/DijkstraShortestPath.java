package dijkstra;

public class DijkstraShortestPath {
    static int vertices = 6;
    
    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 0, 0, 0},
            {1, 0, 0, 5, 1, 0},
            {2, 0, 0, 2, 3, 0},
            {0, 5, 2, 0, 2, 2},
            {0, 1, 3, 2, 0, 1},
            {0, 0, 0, 2, 1, 0}
        };
        
        int[][] graph1 = {
            {0, 2, 0, 8, 0, 0},
            {0, 0, 0, 5, 6, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 5, 0, 0, 3, 2},
            {0, 0, 4, 0, 0, 1},
            {0, 0, 3, 0, 0, 0}
        };
        GreedyDijkstra(graph, 0);
        GreedyDijkstra(graph1, 0);
    }
    
    static int minimumDistance(int[] distance, boolean[] visitedVertices) {
        int minimum = Integer.MAX_VALUE;
        int index = -1;
        
        for (int i = 0; i < distance.length; i++) {
            if (!visitedVertices[i] && distance[i] < minimum) {
                minimum = distance[i];
                index = i;
            }
        }
        return index;
    }
    
    static void GreedyDijkstra(int[][] graph, int sourceVertex) {
        int[] distance = new int[vertices];
        boolean[] visitedVertices = new boolean[vertices];
        
        // Set all the vertices to Infinity
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            visitedVertices[i] = false;
        }
        
        // Pick the source vertex, set initial distance to 0
        distance[sourceVertex] = 0;
        
        for (int j = 0; j < vertices; j++) {
            int minDistance = minimumDistance(distance, visitedVertices);
            visitedVertices[minDistance] = true;
            
            for (int k = 0; k < vertices; k++) {
                if (!visitedVertices[k] && graph[minDistance][k] != 0 && distance[minDistance] != Integer.MAX_VALUE && distance[minDistance] + graph[minDistance][k] < distance[k]) {
                    distance[k] = distance[minDistance] + graph[minDistance][k];
                }
            }
        }
        System.out.println("Vertex\t\tdistance from source vertex");
        for (int k = 0; k < vertices; k++) {
            char str = (char) (65 + k);
            System.out.println(str + "\t\t\t" + distance[k]);
        }
    }
}
