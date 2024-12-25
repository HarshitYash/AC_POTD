//https://codeforces.com/problemset/problem/520/A?mobile=false 

import java.util.Scanner;

public class Pangram {

    public boolean pangram(String input) {
        boolean[] alphabet = new boolean[26];
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                alphabet[ch - 'a'] = true;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] != true) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of characters: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the string: ");
        String input = sc.nextLine();

        Pangram pg = new Pangram();

        if (pg.pangram(input)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        sc.close();
    }
}