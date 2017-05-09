/*
Consider an array of  integers, , where all but one of the integers occur in pairs. In other words, every element in  occurs exactly twice except for one unique element.

Given , find and print the unique element.

Input Format

The first line contains a single integer, , denoting the number of integers in the array. 
The second line contains  space-separated integers describing the respective values in .

Constraints

It is guaranteed that  is an odd number.
, where .
Output Format

Print the unique number that occurs only once in  on a new line.

Sample Input 0

1
1

Sample Output 0

1
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int lonelyInteger(int[] a) {
        Map<Integer, Boolean> unique = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i < a.length; i++) {
            if (unique.containsKey(a[i])) {
                unique.put(a[i], false);
            } else {
                unique.put(a[i], true);
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            if (unique.get(a[i]) == true) {
                return a[i];
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }
}
