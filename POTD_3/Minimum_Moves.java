//https://leetcode.com/problems/minimum-moves-to-convert-string/description/

import java.util.Scanner;

public class Minimum_Moves {
    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'X') {
                i += 3;
                moves++;
            } else
                i++;
        }
        return moves;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String s = sc.next();
        Minimum_Moves min = new Minimum_Moves();

        int result = min.minimumMoves(s);
        System.out.println("Minimum moves : " + result);

        sc.close();
    }
}
