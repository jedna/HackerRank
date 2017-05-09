/*
Davis has  staircases in his house and he likes to climb each staircase , , or  steps at a time. Being a very precocious child, he wonders how many ways there are to reach the top of the staircase.

Given the respective heights for each of the  staircases in his house, find and print the number of ways he can climb each staircase on a new line.

Input Format

The first line contains a single integer, , denoting the number of staircases in his house. 
Each line  of the  subsequent lines contains a single integer, , denoting the height of staircase .

Constraints

Subtasks

 for  of the maximum score.
Output Format

For each staircase, print the number of ways Davis can climb it in a new line.

Sample Input

3
1
3
7

Sample Output

1
4
44
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            System.out.println(countWays(n, m));
        }
    }
    
    public static int countWays(int stairs, Map<Integer, Integer> mem) {
        if (mem.containsKey(stairs)) {
            return mem.get(stairs);
        }
        
        if (stairs == 1) {
            return 1;
        }
        
        if (stairs == 2) {
            return 2;
        }
        
        if (stairs == 3) {
            return 4;
        }
        
        int ways = countWays(stairs - 1, mem) + countWays(stairs - 2, mem) + countWays(stairs - 3, mem); 
        mem.put(stairs, ways);
        
        return ways;
    }
}
