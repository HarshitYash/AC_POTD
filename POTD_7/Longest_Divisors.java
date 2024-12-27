//https://codeforces.com/problemset/problem/1855/B

import java.io.*;
import java.util.*;

public class Longest_Divisors {
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

    public static int getSize(long n) {
        int max = 1;
        long factor = 2;

        while (factor * factor <= n) {
            if (n % factor == 0) {
                int count = 0;
                while (n % factor == 0) {
                    n /= factor;
                    count++;
                }
                max = Math.max(max, count + 1);
            }
            factor++;
        }

        if (n > 1) {
            max = Math.max(max, 2);
        }

        return max;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            int t = in.nextInt();
            long[] cases = new long[t];

            // Reading test cases
            for (int i = 0; i < t; i++) {
                cases[i] = in.nextLong();
            }

            // Processing and output
            for (int i = 0; i < t; i++) {
                out.println(getSize(cases[i]));
            }

            // Flush output once after all results
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
