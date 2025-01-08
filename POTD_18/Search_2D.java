//https://leetcode.com/problems/search-a-2d-matrix/description/

import java.util.*;
import java.io.*;

public class Search_2D {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        char nextChar() {
            return next().charAt(0);
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void flush() throws IOException {
            bw.flush();
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int column = m - 1;
        while (row < n && column >= 0) {
            int current = matrix[row][column];
            if (target < current)
                column--;
            else if (target > current)
                row++;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the number of rows in the matrix: ");
            out.flush();
            int m = in.nextInt();
            out.print("Enter the number of columns in the matrix: ");
            out.flush();
            int n = in.nextInt();

            int[][] matrix = new int[m][n];
            out.println("Enter the elements of the matrix :");
            out.flush();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            out.print("Enter the target value to search: ");
            out.flush();
            int target = in.nextInt();

            Search_2D obj = new Search_2D();
            boolean result = obj.searchMatrix(matrix, target);
            if (result) {
                out.println("Target " + target + " found in the matrix.");
                out.flush();
            } else {
                out.println("Target " + target + " not found in the matrix.");
                out.flush();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}