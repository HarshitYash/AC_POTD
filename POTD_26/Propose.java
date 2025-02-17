//https://codeforces.com/group/X1jmHxEVlA/contest/503893/problem/C

import java.util.*;

public class Propose {
    public static boolean isLazyMatch(String s, String word) {
        int i = 0, j = 0;
        int n = s.length(), m = word.length();

        while (i < n && j < m) {
            char current = s.charAt(i);
            int sCount = 0, wCount = 0;

            while (i < n && s.charAt(i) == current) {
                sCount++;
                i++;
            }

            while (j < m && word.charAt(j) == current) {
                wCount++;
                j++;
            }

            if (wCount > sCount || (sCount < 3 && sCount != wCount)) {
                return false;
            }
        }

        return i == n && j == m;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        int n = scanner.nextInt();
        scanner.nextLine();

        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(scanner.nextLine());
        }

        int lazyMatchCount = 0;

        for (String word : words) {
            if (isLazyMatch(s, word)) {
                lazyMatchCount++;
            }
        }

        System.out.println(lazyMatchCount);
        scanner.close();
    }
}
