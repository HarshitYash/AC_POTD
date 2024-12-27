//https://codeforces.com/problemset/problem/1855/B

import java.io.*;
import java.util.*;

class Happy_Number {
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

    public static boolean isHappy(int n) {
        int rem = 0, sum = 0, c = 0;
        while (sum != 1) {
            while (n > 0) {
                rem = n % 10;
                sum = sum + (rem * rem);
                n = n / 10;
            }
            if (c > 10)
                return sum == 1;
            n = sum;
            sum = 0;
            c++;
        }
        return sum == 1;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the number : ");
            out.flush();
            int m = in.nextInt();
            boolean t = isHappy(m);
            if (t) {
                out.println(m + " is an happy number.");
                out.flush();
            } else {
                out.println(m + " is not an happy number.");
                out.flush();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}