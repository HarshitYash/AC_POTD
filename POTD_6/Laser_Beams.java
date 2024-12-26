//https://leetcode.com/problems/number-of-laser-beams-in-a-bank/description/

import java.util.*;
import java.io.*;

class Laser_Beams {
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

    public static int numberOfBeams(String[] bank) {
        int result = 0, last = 0;
        for (int i = 0; i < bank.length; i++) {
            int n = 0;
            for (int j = 0; j < bank[i].length(); j++)
                if (bank[i].charAt(j) == '1')
                    n++;
            if (n == 0)
                continue;
            result += last * n;
            ;
            last = n;
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the number of rows: ");
            out.flush();
            int m = in.nextInt();
            out.print("Enter the number of columns: ");
            out.flush();
            int n = in.nextInt();

            String[] bank = new String[m];
            out.println("Enter the binary strings :");
            out.flush();
            for (int i = 0; i < m; i++) {
                bank[i] = in.nextLine();
                if (bank[i].length() != n) {
                    out.println("Error: Each row must have exactly " + n + " characters.");
                    out.flush();
                    return;
                }
            }

            out.println("Total number of laser beams: " + numberOfBeams(bank));
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}