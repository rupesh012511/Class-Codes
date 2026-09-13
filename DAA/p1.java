//Counting number of ways in which amount can be formed

import java.util.Scanner;

public class p1 {
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
        if(amount == 0) return 1;

        if(amount < 0 || index > coins.length-1) return 0;

        //Task
        int consider = CoinChange(index, coins, amount - coins[index]);

        int leave = CoinChange(index + 1, coins, amount);

        return consider + leave;
    }

}