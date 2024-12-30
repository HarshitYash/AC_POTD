//https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

import java.util.*;
import java.io.*;

public class Deci_Binary {
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

    public int minPartitions(String n) {
        int maxDigit = 0;

        for (int i = 0; i < n.length(); i++) {
            maxDigit = Math.max(maxDigit, n.charAt(i) - '0');
            if (maxDigit == 9)
                break;
        }

        return maxDigit;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter any number : ");
            out.flush();
            String num = in.nextLine();

            Deci_Binary solution = new Deci_Binary();
            int result = solution.minPartitions(num);

            out.println("The minimum number of Deci-Binary numbers is : " + result);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
