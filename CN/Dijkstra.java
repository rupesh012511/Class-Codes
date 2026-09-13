
public class Dijkstra {

    static final int V = 5; // number of vertices

    // Function to find minimum distance vertex
    static int minDistance(int dist[], boolean visited[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    // Dijkstra Algorithm
    static void dijkstra(int graph[][], int src) {
        int dist[] = new int[V];        // shortest distances
        boolean visited[] = new boolean[V]; // visited nodes

        // Initialize
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }

        dist[src] = 0;

        // Main loop
        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                    dist[u] != Integer.MAX_VALUE &&
                    dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // Print result
        System.out.println("Vertex\tDistance");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t" + dist[i]);
        }
    }

    public static void main(String[] args) {

        int graph[][] = {
            {0, 4, 2, 0, 0},
            {4, 0, 5, 10, 0},
            {2, 5, 0, 0, 3},
            {0, 10, 0, 0, 4},
            {0, 0, 3, 4, 0}
        };

        int source = 0;

        dijkstra(graph, source);
    }
}
