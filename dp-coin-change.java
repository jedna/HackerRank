/*
Given a number of dollars, , and a list of dollar values for  distinct coins, , find and print the number of different ways you can make change for  dollars if each coin is available in an infinite quantity.

Hints:

You can solve this problem recursively, but you must optimize your solution to eliminate overlapping subproblems using Dynamic Programming if you wish to pass all test cases. More specifically, think of ways to store the checked solutions and use the stored values to avoid repeatedly calculating the same values.
Think about the degenerate cases: 
How many ways can you make change for  dollars?
How many ways can you make change for less than  dollars if you have no coins?
If you are having trouble defining the storage for your precomputed values, then think about it in terms of the base case .
Input Format

The first line contain two space-separated integers describing the respective values of  and . 
The second line contains  space-separated integers describing the respective values of , where each integer denotes the dollar value of a distinct coin available in an infinite quantity.

Constraints

The list of coins contains  distinct integers where each integer denotes the dollar value of a coin available in an infinite quantity.
Output Format

Print a single integer denoting the number of ways we can make change for  dollars using an infinite supply of our  types of coins.

Sample Input 0

4 3
1 2 3 

Sample Output 0

4
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChange(int[] coins, int money) {
        if (coins.length == 0) {
            return 0;
        }
        
        if (money <= 0) {
            return 1;
        }
        
        //Arrays.sort(coins);
        
        int n = coins.length;
        long[] tbl = new long[money + 1];
        
        tbl[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= money; j++) {
                tbl[j] += tbl[j - coins[i]];
                //System.out.println("Adding " + coins[i] + " coin, value " + j + ", solutions " + tbl[j] + ", money " + money);
            }
        }
            
        //for (int i = 0; i < tbl.length; i++) {
        //    System.out.println(i + ":" + tbl[i]);
        //}
        
        return tbl[money];
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        
        System.out.println(makeChange(coins, n));
    }
}
