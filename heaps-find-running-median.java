/*
The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers are less than and greater than the value. To find the median, you must first sort your dataset of integers in non-decreasing order, then:

If your dataset contains an odd number of elements, the median is the middle element of the sorted sample. In the sorted dataset ,  is the median.
If your dataset contains an even number of elements, the median is the average of the two middle elements of the sorted sample. In the sorted dataset ,  is the median.
Given an input stream of  integers, you must perform the following task for each  integer:

Add the  integer to a running list of integers.
Find the median of the updated list (i.e., for the first element through the  element).
Print the list's updated median on a new line. The printed value must be a double-precision number scaled to decimal place (i.e.,  format).
Input Format

The first line contains a single integer, , denoting the number of integers in the data stream. 
Each line  of the  subsequent lines contains an integer, , to be added to your list.

Constraints

Output Format

After each new integer is added to the list, print the list's updated median on a new line as a single double-precision number scaled to  decimal place (i.e.,  format).

Sample Input

6
12
4
5
3
8
7

Sample Output

12.0
8.0
5.0
4.5
5.0
6.0

*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> lower = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> higher = new PriorityQueue<Integer>();

        int n = in.nextInt();
        int temp = 0;
        
        for(int a_i=0; a_i < n; a_i++){
            temp = in.nextInt();
            
            if (! lower.isEmpty() && lower.peek() >= temp) {
                lower.offer(temp);
            } else {
                higher.offer(temp);
            }
            
            if (lower.size() > higher.size()) {
                higher.offer(lower.poll());
            }
            if (higher.size() - lower.size() > 1) {
                lower.offer(higher.poll());
            }
            
            double median;
            if (lower.size() == higher.size()) {
                median = (lower.peek() + higher.peek()) / 2.0;
            } else {
                median = higher.peek();
            }
            System.out.printf("%.1f\n", median);
        }
    }
}
