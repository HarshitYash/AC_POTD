//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1

import java.util.*;
import java.io.*;

public class Floor_Array {
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

    static int findFloor(int[] arr, int k) {
        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                max = i;
            } else
                break;
        }
        return max;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the size of the array: ");
            out.flush();
            int n = in.nextInt();

            int[] arr = new int[n];
            out.println("Enter the elements of the sorted array:");
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            out.print("Enter the value of k: ");
            out.flush();
            int k = in.nextInt();

            out.println("Floor index: " + findFloor(arr, k));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}