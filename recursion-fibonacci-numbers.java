/*
The Fibonacci sequence begins with  and  as its respective first and second terms. After these first two elements, each subsequent element is equal to the sum of the previous two elements.

Here is the basic information you need to calculate :

Task 
Given , complete the fibonacci function so it returns .

Input Format

Locked stub code in the editor reads a single integer denoting the value of  and passes it to the fibonacci function.

Constraints

Output Format

Locked stub code in the editor prints the value of  returned by the fibonacci function.

Sample Input

3  

Sample Output

2
*/

import java.util.*;

public class Solution {

    
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
      
        return fibonacci(n-1) + fibonacci(n-2);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
