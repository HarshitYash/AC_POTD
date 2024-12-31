//https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.*;
import java.io.*;

class Reverse_Words {

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

    public String reverseWords(String s) {
        String result = "";
        String word = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c != ' ') {
                word = c + word;
            } else {
                if (!word.isEmpty()) {
                    if (!result.isEmpty()) {
                        result += " ";
                    }
                    result += word;
                    word = "";
                }
            }
        }

        if (!word.isEmpty()) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += word;
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            FastReader in = new FastReader();
            FastWriter out = new FastWriter();

            out.print("Enter a string : ");
            out.flush();
            String input = in.nextLine();

            Reverse_Words obj = new Reverse_Words();

            String reversed = obj.reverseWords(input);
            out.println("Reversed words: " + reversed);
            out.flush();

            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}