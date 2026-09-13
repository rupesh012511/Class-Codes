//Min number of coins to form the given amount

import java.util.Scanner;

public class p2 {
    static int INF = 100000;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=sc.nextInt();
        }
        int amount = sc.nextInt();
        int result = CoinChange(0, coins, amount);
        System.out.println(result);
    }

    public static int CoinChange( int index, int[] coins, int amount){
        //BASE
        if(amount == 0) return 0;

        if(amount < 0 || index > coins.length-1) return INF;

        //Task
        int consider = 1 + CoinChange(index, coins, amount - coins[index]);

        int leave = CoinChange(index + 1, coins, amount);

        return Math.min(consider, leave);
    }

}