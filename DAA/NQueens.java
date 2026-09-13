import java.util.*;

public class NQueens {

    static List<int[]> ans = new ArrayList<>();

    // Check whether queen can be placed safely
    static boolean isSafe(int[][] board, int row, int col, int n) {

        // Check upper column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 1)
                return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n;
             i--, j++) {

            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    // Backtracking function
    static void solve(int[][] board, int row, int n) {

        // All queens placed
        if (row == n) {

            int[] config = new int[n];

            // Convert board into required format
            // index = column
            // value = row
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (board[i][j] == 1) {
                        config[j] = i;
                        break;
                    }
                }
            }

            ans.add(config);
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 1;

                // Recur for next row
                solve(board, row + 1, n);

                // Backtrack
                board[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] board = new int[n][n];

        solve(board, 0, n);

        // No solution
        if (ans.size() == 0) {
            System.out.println(-1);
            return;
        }

        // Print all configurations
        for (int[] arr : ans) {

            for (int i = 0; i < arr.length; i++) {

                System.out.print(arr[i]);

                if (i != arr.length - 1)
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}
