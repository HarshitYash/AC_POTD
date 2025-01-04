//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/description/

import java.util.*;
import java.io.*;

public class Move_Balls {
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

    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = 0;
            for (int j = 0; j < n; j++) {
                if (boxes.charAt(j) == '1') {
                    answer[i] += Math.abs(j - i);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the binary string representing the boxes: ");
            out.flush();
            String boxes = in.nextLine();

            if (!boxes.matches("[01]+")) {
                out.println("Invalid input. Please enter a binary string containing only '0' and '1'.");
                out.flush();
                return;
            }
            Move_Balls obj = new Move_Balls();
            int[] result = obj.minOperations(boxes);
            out.println("Minimum operations for each box: " + Arrays.toString(result));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
