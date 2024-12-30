//https://leetcode.com/problems/product-of-array-except-self/description/

import java.util.*;
import java.io.*;

class Array_Product {

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

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        prefix[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.println("Enter the size of the array:");
            out.flush();
            int size = in.nextInt();
            int[] arr = new int[size];

            out.println("Enter the elements of the array:");
            out.flush();
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
            }

            Array_Product solution = new Array_Product();
            int[] result = solution.productExceptSelf(arr);

            out.println("The Updated array is:");
            out.flush();

            for (int j = 0; j < size; j++) {
                out.print(result[j] + " ");
                out.flush();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}