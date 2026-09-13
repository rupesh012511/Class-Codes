
import java.util.*;

public class obstp1 {

    public static void computeOBSTMatrix(int[] freq, int[][] cost) {

        int n = freq.length,j;

        for(int i=0;i<n;i++){
            cost[i][i]=freq[i];
        }

        for(int len=2;len<=n;len++){

            for(int i=0;i<=n-len;i++){
                j=i+len-1;

                cost[i][j]=Integer.MAX_VALUE;

                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=freq[k];
                }

                for(int r=i;r<=j;r++){
                    int left=0;
                    int right=0;

                    if(r>i) left=cost[i][r-1];
                    if(r<j) right=cost[r+1][j];

                    int total = left + right+sum;

                    cost[i][j]=Math.min(cost[i][j],total);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] freq = new int[n];

        for (int i = 0; i < n; i++) {
            freq[i] = sc.nextInt();
        }

        int[][] cost = new int[n][n];

        computeOBSTMatrix(freq, cost);

        // Print cost matrix
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                System.out.print(cost[i][j]);

                if (j != n - 1)
                    System.out.print(" ");
            }

            System.out.println();
        }

        sc.close();
    }
}
