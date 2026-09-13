import java.util.*;

public class djp {

    static int[] dijkstra(ArrayList<int[]>[] arr, int S, int v){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S]=0;
        pq.offer(new int[]{0, S});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int dis = curr[0];
            int node = curr[1];

            for(int[] edge: arr[node]){
                int adjnode = edge[0];
                int wt = edge[1];

                if(dis + wt < dist[adjnode]){
                    dist[adjnode]=dis+wt;
                    pq.offer(new int[]{dist[adjnode],adjnode});
                }
            }
        }


        return dist;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        ArrayList<int[]>[] arr = new ArrayList[V];

        for(int i=0;i<V;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            arr[u].add(new int[]{v, w});
            arr[v].add(new int[]{u, w});
        }

        int S = sc.nextInt();

        int[] result = dijkstra(arr, S, V);

        for(int i=0;i<V;i++){
            System.out.print(i+" "+result[i]);
        }
        System.out.println();
    }
}

// 5	
// 6	
// 0 1 2	
// 0 2 4	
// 1 2 1	
// 1 3 7	
// 2 4 3	
// 3 4 1	
// 0
