//recursion

import java.util.Scanner;

public class LCSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int ans = lcs(0, 0, s1, s2);

        System.out.println(ans);
    }

    public static int lcs(int i, int j, String s1, String s2) {

        // BASE CASE
        if(i == s1.length() || j == s2.length()) {
            return 0;
        }

        // MATCH
        if(s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs(i + 1, j + 1, s1, s2);
        }

        // NOT MATCH
        int skipS1 = lcs(i + 1, j, s1, s2);

        int skipS2 = lcs(i, j + 1, s1, s2);

        return Math.max(skipS1, skipS2);
    }
}

//memoization

// import java.util.Arrays;
// import java.util.Scanner;

// public class LCSMemo {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         String s1 = sc.next();
//         String s2 = sc.next();

//         int[][] dp = new int[s1.length()][s2.length()];

//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         int ans = lcs(0, 0, s1, s2, dp);

//         System.out.println(ans);
//     }

//     public static int lcs(int i, int j,
//                           String s1,
//                           String s2,
//                           int[][] dp) {

//         // BASE
//         if(i == s1.length() || j == s2.length()) {
//             return 0;
//         }

//         // ALREADY COMPUTED
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         // MATCH
//         if(s1.charAt(i) == s2.charAt(j)) {

//             dp[i][j] =
//                 1 + lcs(i + 1, j + 1, s1, s2, dp);

//             return dp[i][j];
//         }

//         // NOT MATCH
//         int skipS1 =
//             lcs(i + 1, j, s1, s2, dp);

//         int skipS2 =
//             lcs(i, j + 1, s1, s2, dp);

//         dp[i][j] = Math.max(skipS1, skipS2);

//         return dp[i][j];
//     }
// }
