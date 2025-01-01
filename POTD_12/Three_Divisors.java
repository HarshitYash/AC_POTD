//https://leetcode.com/problems/three-divisors/description/

import java.util.*;
import java.io.*;

public class Three_Divisors {
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

    public boolean isThree(int n) {
        int count = 1;
        if (n % 2 == 0) {
            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    count++;
                }
                if (count > 3) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= n / 3; i++) {
                if (n % i == 0) {
                    count++;
                }
                if (count > 3) {
                    return false;
                }
            }
        }
        if (count == 3)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter any number :- ");
            out.flush();
            int m = in.nextInt();
            Three_Divisors obj = new Three_Divisors();
            boolean divisor = obj.isThree(m);
            if (divisor) {
                out.println("GIVEN NUMBER HAS THREE DIVISORS.");
                out.flush();
            } else {
                out.println("GIVEN NUMBER HAS NOT THREE DIVISORS.");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}