import java.util.*;

public class hamiltonianp {
    static int n;
    static int[] path;
    static int[][] graph;

    static boolean issafe(int v, int pos){
        if(graph[path[pos-1]][v]==0) return false;
        for(int i=0;i<n;i++){
            if(path[i]==v) return false;
        }
        return true;
    }

    static boolean solve(int pos){
        if(pos == n){
            if(graph[path[pos-1]][path[0]]==1) return true;

            return false;
        }

        for(int v=1;v<n;v++){
            if(issafe(v, pos)){
                path[pos]=v;

                if(solve(pos+1)) return true;

                path[pos]=-1;
            }
        }
        return false;
    }
        public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for(int j=0; j<n;j++){
                graph[i][j]=sc.nextInt();
            }
            
        }

        path = new int[n];

        Arrays.fill(path, -1);

        path[0]=0;

        if(solve(1)){

            for(int i=0;i<n;i++){
                System.out.print(path[i]+" ");
            }

            System.out.println(0);

        } else{
            System.out.println("Sol not found");
        }
    }

    
}


// 5	
// 0 1 0 1 0	
//0 1 0 1 0		
// 0 1 0 0 1	
// 1 1 0 0 1	
// 0 1 1 1 0
