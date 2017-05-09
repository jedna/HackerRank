/*
In an array, , the elements at indices  and  (where ) form an inversion if . In other words, inverted elements  and  are considered to be "out of order". To correct an inversion, we can swap adjacent elements.

For example, consider . It has two inversions:  and . To sort the array, we must perform the following two swaps to correct the inversions:

Given  datasets, print the number of inversions that must be swapped to sort each dataset on a new line.

Input Format

The first line contains an integer, , denoting the number of datasets. 
The  subsequent lines describe each respective dataset over two lines:

The first line contains an integer, , denoting the number of elements in the dataset.
The second line contains  space-separated integers describing the respective values of .
Constraints

Output Format

For each of the  datasets, print the number of inversions that must be swapped to sort the dataset on a new line.

Sample Input

2  
5  
1 1 1 2 2  
5  
2 1 3 1 2

Sample Output

0  
4   
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static long countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        
        return mergeSort(arr, temp, 0, arr.length -1);
    }
    
    public static long mergeSort(int[] arr, int[] temp, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = (left + right) / 2;
        
        // System.out.println("Sorting from " + left + " to " + right);
        
        return mergeSort(arr, temp, left, mid) + 
               mergeSort(arr, temp, mid + 1, right) + 
               mergeHalves(arr, temp, left, mid, right);
    }
    
    public static long mergeHalves(int[] arr, int[] temp, int leftStart, int leftEnd, int rightEnd) {
        int rightStart = leftEnd + 1;
        long count = 0;
        int size = rightEnd - leftStart + 1;
        
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        
        
        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                count += leftEnd + 1 - left;
                right++;
            }
            index++;
        }
        
        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);
        
        return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }
    
    
}
