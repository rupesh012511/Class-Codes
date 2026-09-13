import java.util.*;

class Edge {
    int src;
    int dst;
    int wt;

    Edge(int sr, int dt, int w){
        this.src = sr;
        this.dst = dt;
        this.wt = w;
    }
}

public class Practice{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Edge> lst = new ArrayList<>();


        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            lst.add(new Edge(x, y, w));
        }

        sc.close();
    }
} 
