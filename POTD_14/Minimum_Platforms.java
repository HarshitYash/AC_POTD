//https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.*;
import java.io.*;

public class Minimum_Platforms {
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

    static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;
        int[] total = new int[2400];

        for (int i = 0; i < n; i++) {
            total[arr[i]]++;
            total[dep[i] + 1]--;
        }

        int req = 0;
        int max = 0;

        for (int i = 0; i < 2400; i++) {
            req += total[i];
            if (req > max) {
                max = req;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the number of trains: ");
            out.flush();
            int n = in.nextInt();

            int[] arr = new int[n];
            int[] dep = new int[n];

            out.println("Enter the arrival times of trains (HHMM):");
            out.flush();
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }

            out.println("Enter the departure times of trains (HHMM):");
            out.flush();
            for (int i = 0; i < n; i++) {
                dep[i] = in.nextInt();
            }

            int result = findPlatform(arr, dep);
            out.println("Minimum platforms required: " + result);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
