//https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1

import java.util.*;
import java.io.*;

public class Find_Root {
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

    public int nthRoot(int n, int m) {
        if (n == 1) {
            return m;
        }

        int min = 1, max = m;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            long power = (long) Math.pow(mid, n);

            if (power > m) {
                max = mid - 1;
            } else if (power < m) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the value of root : ");
            out.flush();
            int n = in.nextInt();

            out.print("Enter the value of the number to find the root of : ");
            out.flush();
            int m = in.nextInt();

            Find_Root obj = new Find_Root();
            int result = obj.nthRoot(n, m);
            if (result == -1) {
                out.println("The " + n + "-th root of " + m + " is not an integer.");
                out.flush();
            } else {
                out.println("The " + n + "-th root of " + m + " is: " + result);
                out.flush();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}