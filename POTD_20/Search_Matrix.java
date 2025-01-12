//https://leetcode.com/problems/search-a-2d-matrix-ii/

import java.util.*;

public class Search_Matrix {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of rows: ");
            int rows = scanner.nextInt();
            
            System.out.print("Enter the number of columns: ");
            int cols = scanner.nextInt();
            
            if (rows <= 0 || cols <= 0) {
                System.out.println("Matrix dimensions must be greater than 0.");
                return;
            }
            
            int[][] matrix = new int[rows][cols];
            System.out.println("Enter the elements of the matrix row by row:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            
            System.out.print("Enter the target value to search: ");
            int target = scanner.nextInt();
            
            Search_Matrix obj = new Search_Matrix();
            boolean result = obj.searchMatrix(matrix, target);
            
            System.out.println(result);
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int row = 0;
        int column = matrix[0].length - 1;
        while (row < n && column >= 0) {
            if (matrix[row][column] > target) {
                column--;
            } else if (matrix[row][column] < target)
                row++;
            else
                return true;
        }
        return false;
    }
}
