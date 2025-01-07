//https://leetcode.com/problems/arranging-coins/description/

import java.util.*;
import java.io.*;

public class Arranging_Coins {
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

    public int arrangeCoins(int n) {
        long left = 1;
        long right = (long) n;
        long k, present;
        while (left <= right) {
            k = left + (right - left) / 2;
            present = k * (k + 1) / 2;
            if (n < present) {
                right = k - 1;
            } else if (n > present) {
                left = k + 1;
            } else {
                return (int) k;
            }
        }
        return (int) (left - 1);
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the number of coins : ");
            out.flush();
            int n = in.nextInt();

            Arranging_Coins obj = new Arranging_Coins();
            out.println("Total complete rows : " + obj.arrangeCoins(n));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}