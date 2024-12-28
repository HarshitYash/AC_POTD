//https://leetcode.com/problems/convert-1d-array-into-2d-array/

import java.io.*;
import java.util.*;

public class Array_Conversion {
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

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        }
        int t = 0;
        int[][] duplicate = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                duplicate[i][j] = original[t];
                t++;
            }
        }
        return duplicate;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.println("Enter the size of the 1D array:");
            out.flush();
            int size = in.nextInt();
            int[] original = new int[size];

            out.println("Enter the elements of the 1D array:");
            out.flush();
            for (int i = 0; i < size; i++) {
                original[i] = in.nextInt();
            }

            out.println("Enter the number of rows (m):");
            out.flush();
            int m = in.nextInt();

            out.println("Enter the number of columns (n):");
            out.flush();
            int n = in.nextInt();

            Array_Conversion solution = new Array_Conversion();
            int[][] result = solution.construct2DArray(original, m, n);

            out.println("The 2D array is:");
            out.flush();

            if (result.length == 0) {
                out.println("Empty 2D array");
                out.flush();
            } else {
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        out.print(result[i][j] + " ");
                        out.flush();
                    }
                    System.out.println();
                }
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}