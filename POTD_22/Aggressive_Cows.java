//https://www.geeksforgeeks.org/problems/aggressive-cows/1

import java.util.*;

public class Aggressive_Cows{ 
    public static void main(String[] args) {
        // Input number of stalls
        try (Scanner scanner = new Scanner(System.in)) {
            // Input number of stalls
            System.out.print("Enter the number of stalls: ");
            int n = scanner.nextInt();
            
            // Input stall positions
            int[] stalls = new int[n];
            System.out.println("Enter the positions of the stalls: ");
            for (int i = 0; i < n; i++) {
                stalls[i] = scanner.nextInt();
            }
            
            // Input number of cows
            System.out.print("Enter the number of cows: ");
            int k = scanner.nextInt();
            
            // Find and display the largest minimum distance
            int result = aggressiveCows(stalls, k);
            System.out.println("Largest Minimum Distance: " + result);
        }
    }
    
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls);

        int low = 1;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(stalls, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    private static boolean check(int[] stalls, int k, int distance) {
        int count = 1;
        int last = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= distance) {
                count++;
                last = stalls[i];
                if (count == k) {
                    return true;
                }
            }
        }
        return false;
    }
}