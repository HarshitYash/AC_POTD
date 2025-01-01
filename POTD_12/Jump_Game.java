//https://leetcode.com/problems/jump-game/description/

import java.util.*;
import java.io.*;

public class Jump_Game {
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

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false;
            }
            if (i + nums[i] > maxReach) {
                maxReach = i + nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter the size of the array : ");
            out.flush();
            int size = in.nextInt();
            int[] real = new int[size];

            out.println("Enter the elements of the array:");
            out.flush();
            for (int i = 0; i < size; i++) {
                real[i] = in.nextInt();
            }

            Jump_Game obj = new Jump_Game();
            boolean value = obj.canJump(real);
            if (value) {
                out.println("It can be reached to the last index.");
                out.flush();
            } else {
                out.println("It can't be reached to the last index.");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}