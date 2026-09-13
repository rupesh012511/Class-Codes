import java.util.*;

public class knapsack {

    static int[][] dp;

    static int knapsack(int[] profit,
                        int[] weight,
                        int n,
                        int capacity) {

        // Base case
        if (n == 0 || capacity == 0)
            return 0;

        // Already solved
        if (dp[n][capacity] != -1)
            return dp[n][capacity];

        // Cannot include item
        if (weight[n - 1] > capacity) {

            dp[n][capacity] =
                    knapsack(profit,
                             weight,
                             n - 1,
                             capacity);
        }

        else {

            // Include
            int include =
                    profit[n - 1]
                    + knapsack(profit,
                               weight,
                               n - 1,
                               capacity - weight[n - 1]);

            // Exclude
            int exclude =
                    knapsack(profit,
                             weight,
                             n - 1,
                             capacity);

            dp[n][capacity] =
                    Math.max(include, exclude);
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int capacity = sc.nextInt();

        int[] profit = new int[n];
        int[] weight = new int[n];

        for (int i = 0; i < n; i++)
            profit[i] = sc.nextInt();

        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();

        dp = new int[n + 1][capacity + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(
                knapsack(profit,
                         weight,
                         n,
                         capacity)
        );
    }
}