//recursion version

import java.util.Scanner;

public class LCSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.next();
        String s2 = sc.next();

        int ans = 0;

        // Try every starting pair
        for(int i = 0; i < s1.length(); i++) {

            for(int j = 0; j < s2.length(); j++) {

                ans = Math.max(ans,
                        substring(i, j, s1, s2));
            }
        }

        System.out.println(ans);
    }

    public static int substring(int i,
                                int j,
                                String s1,
                                String s2) {

        // BASE
        if(i == s1.length() ||
           j == s2.length()) {

            return 0;
        }

        // MATCH
        if(s1.charAt(i) == s2.charAt(j)) {

            return 1 +
                   substring(i + 1,
                             j + 1,
                             s1,
                             s2);
        }

        // MISMATCH
        return 0;
    }
}

//Memoization 

// import java.util.Arrays;
// import java.util.Scanner;

// public class LCSubstringMemo {

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         String s1 = sc.next();
//         String s2 = sc.next();

//         int[][] dp =
//             new int[s1.length()][s2.length()];

//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         int ans = 0;

//         for(int i = 0; i < s1.length(); i++) {

//             for(int j = 0; j < s2.length(); j++) {

//                 ans = Math.max(ans,
//                         substring(i, j,
//                                   s1, s2, dp));
//             }
//         }

//         System.out.println(ans);
//     }

//     public static int substring(int i,
//                                 int j,
//                                 String s1,
//                                 String s2,
//                                 int[][] dp) {

//         // BASE
//         if(i == s1.length() ||
//            j == s2.length()) {

//             return 0;
//         }

//         // ALREADY SOLVED
//         if(dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         // MATCH
//         if(s1.charAt(i) == s2.charAt(j)) {

//             dp[i][j] =
//                 1 + substring(i + 1,
//                               j + 1,
//                               s1,
//                               s2,
//                               dp);

//             return dp[i][j];
//         }

//         // MISMATCH
//         dp[i][j] = 0;

//         return dp[i][j];
//     }
// }
