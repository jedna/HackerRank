/*
Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together  dollars for ice cream. On any given day, the parlor offers a line of  flavors. Each flavor, , is numbered sequentially with a unique ID number from  to  and has a cost, , associated with it.

Given the value of  and the cost of each flavor for  trips to the Ice Cream Parlor, help Sunny and Johnny choose two distinct flavors such that they spend their entire pool of money () during each visit. For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

Note: Two ice creams having unique IDs  and  may have the same cost (i.e., ).

Input Format

The first line contains an integer, , denoting the number of trips to the ice cream parlor. The  subsequent lines describe all of Sunny and Johnny's trips to the parlor; each trip is described as follows:

The first line contains .
The second line contains .
The third line contains  space-separated integers denoting the cost of each respective flavor. The  integer corresponds to the cost, , for the ice cream with ID number  (where ).
Constraints

, where 
It is guaranteed that there will always be a unique solution.
Output Format

Print two space-separated integers denoting the respective ID numbers for the two distinct flavors they choose to purchase, where the smaller ID is printed first and the larger ID is printed second. Recall that each ice cream flavor has a unique ID number in the inclusive range from  to .

Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3

Sample Output

1 4
1 2
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Solution {

    public static void main(String[] args) {
        
        int t;
        int n, m;
 
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {       
            
            m = in.nextInt();
            n = in.nextInt(); 
            int[] arr = new int[n];
    
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                //System.out.println(arr[i]);
            }            
                        
            outerloop:
            for(int i = 0; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (i != j && m == arr[i] + arr[j]) {
                        //System.out.println(i + " = " + arr[i] + " + " + j + " = " + arr[j]);
                        System.out.println((i + 1) + " " + (j + 1));
                        break outerloop;
                    }    
                }
            } 
        }
    }
}
