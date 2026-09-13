import java.util.*;

class Edge {
    int src, dst, wt;
    Edge(int s, int d, int w){
        this.src=s;
        this.dst=d;
        this.wt=w;
    }
}

public class primsp {
    static int FindParent(int[] parent, int x){
        if(parent[x]==x) return x;

        return FindParent(parent, parent[x]);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] graph = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->a.wt-b.wt);

        for(int i=0;i<n;i++){
            if(graph[0][i]>0) pq.offer(new Edge(0,i,graph[0][i]));
        }

        //make parents
        int[] parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        ArrayList<Edge> MSTgraph = new ArrayList<>();

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int src = edge.src;
            int dst = edge.dst;
            int wt = edge.wt;
            int psrc = FindParent(parent, src);
            int pdst = FindParent(parent, dst);
            if(psrc!=pdst){
                MSTgraph.add(edge);
                parent[psrc]=pdst;
                for(int i=0;i<n;i++){
                    if(graph[dst][i]>0) pq.offer(new Edge(dst, i, graph[dst][i]));
                }
            }
        }

        int total=0;
        for(Edge ed: MSTgraph){
            total+=ed.wt;
        }

        System.out.print(total);




    }
}

// 5	
// 0 2 0 6 0	
// 2 0 3 8 5	
// 0 3 0 0 7	
// 6 8 0 0 9	
// 0 5 7 9 0
