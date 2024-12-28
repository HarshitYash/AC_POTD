//https://codeforces.com/problemset/problem/1828/B

import java.util.*;
import java.io.*;

public class Permutation_Swap {

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

        public void close() throws IOException {
            bw.close();
        }
    }

    private static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int cases = in.nextInt();

            for (int t = 0; t < cases; t++) {
                int n = in.nextInt();
                int[] p = new int[n];

                for (int i = 0; i < n; i++) {
                    p[i] = in.nextInt();
                }

                int gcd = 0;
                for (int i = 0; i < n; i++) {
                    int diff = Math.abs((i + 1) - p[i]);
                    gcd = findGCD(gcd, diff);
                }
                out.println(gcd);
            }

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}