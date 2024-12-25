//https://leetcode.com/problems/score-of-a-string/

import java.util.Scanner;

class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            sum = sum + Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return sum;
    }
}

public class String_Score {

    public static void main(String[] args) {

        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string:");
        String string = sc.nextLine();

        int score = solution.scoreOfString(string);
        System.out.println("Score: " + score);
        sc.close();
    }
}
