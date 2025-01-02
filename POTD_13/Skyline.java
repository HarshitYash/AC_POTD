//https://leetcode.com/problems/max-increase-to-keep-city-skyline/description/

import java.util.*;
import java.io.*;

public class Skyline {
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

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int rowMax[] = new int[n];
        int colMax[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int rm = rowMax[i];
                int cm = colMax[j];
                int value = Math.min(rm, cm);
                result += value - grid[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the size of the grid (n x m) : ");
            out.flush();
            int n = in.nextInt();
            int m = in.nextInt();

            int[][] grid = new int[n][m];

            out.println("Enter the grid values row by row:");
            out.flush();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = in.nextInt();
                }
            }
            Skyline obj = new Skyline();
            int result = obj.maxIncreaseKeepingSkyline(grid);
            out.println("Total sum that the height of the buildings can be increased: " + result);
            out.flush();

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}