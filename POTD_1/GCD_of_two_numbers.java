//https://www.geeksforgeeks.org/problems/gcd-of-two-numbers3459/1

import java.util.Scanner;

class Solution {
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

public class GCD_of_two_numbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers:");
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = solution.gcd(a, b);

        System.out.println("GCD of " + a + " and " + b + " is: " + result);

        sc.close();
    }
}
