//https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/

import java.util.*;

class Median_Matrix{
    int median(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[] arr = new int[rows * cols];
        int k=0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[k++]=mat[i][j];
            }
        }
        Arrays.sort(arr);
        return arr[arr.length/2];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        Median_Matrix obj = new Median_Matrix();
        System.out.println(obj.median(mat));

        sc.close();
    }
}