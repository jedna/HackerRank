/*
Consider a matrix with  rows and  columns, where each cell contains either a  or a  and any cell containing a  is called a filled cell. Two cells are said to be connected if they are adjacent to each other horizontally, vertically, or diagonally; in other words, cell  is connected to cells , , , , , , , and , provided that the location exists in the matrix for that .

If one or more filled cells are also connected, they form a region. Note that each cell in a region is connected to at least one other cell in the region but is not necessarily directly connected to all the other cells in the region.

Task 
Given an  matrix, find and print the number of cells in the largest region in the matrix. Note that there may be more than one region in the matrix.

Input Format

The first line contains an integer, , denoting the number of rows in the matrix. 
The second line contains an integer, , denoting the number of columns in the matrix. 
Each line  of the  subsequent lines contains  space-separated integers describing the respective values filling each row in the matrix.

Constraints

Output Format

Print the number of cells in the largest region in the given matrix.

Sample Input

4
4
1 1 0 0
0 1 1 0
0 0 1 0
1 0 0 0

Sample Output

5
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static boolean[][] visited;
    
    public static int getBiggestRegion(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        visited = new boolean[R][C];
        
        int max = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (! visited[i][j]) {
                   max = Math.max(max, countNeighbours(matrix, i, j, 0, R, C)); 
                }
            }
        }
        
        return max;
    }
    
    public static int countNeighbours(int[][] matrix, int r, int c, int count, int R, int C) {
        if (r >= R || c >= C || r < 0 || c < 0) {
            return 0;
        }
        
        if (visited[r][c]) {
            return 0;
        }
        
        visited[r][c] = true;
        if (matrix[r][c] == 0) {
            return 0;
        }
        
        return 1 +
            countNeighbours(matrix, r-1, c, count, R, C) + 
            countNeighbours(matrix, r-1, c-1, count, R, C) + 
            countNeighbours(matrix, r-1, c+1, count, R, C) + 
            countNeighbours(matrix, r, c, count, R, C) + 
            countNeighbours(matrix, r, c-1, count, R, C) + 
            countNeighbours(matrix, r, c+1, count, R, C) + 
            countNeighbours(matrix, r+1, c, count, R, C) + 
            countNeighbours(matrix, r+1, c-1, count, R, C) + 
            countNeighbours(matrix, r+1, c+1, count, R, C); 
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }
}
