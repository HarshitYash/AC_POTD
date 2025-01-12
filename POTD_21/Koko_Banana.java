//https://leetcode.com/problems/koko-eating-bananas/description/

import java.util.Scanner;

public class Koko_Banana{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of piles: ");
            int n = scanner.nextInt();

            int[] piles = new int[n];
            System.out.println("Enter the number of bananas in each pile:");
            for (int i = 0; i < n; i++) {
                piles[i] = scanner.nextInt();
            }

            System.out.print("Enter the number of hours (h): ");
            int h = scanner.nextInt();

            Koko_Banana obj = new Koko_Banana();
            int result = obj.minEatingSpeed(piles, h);
            System.out.println("The minimum eating speed (k) is: " + result);

            scanner.close();
        }
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int total = calculateTotalHours(piles, mid);
            if (total <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    public static int findMax(int[] pile) {
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < pile.length; i++) {
            maxi = Math.max(maxi, pile[i]);
        }
        return maxi;
    }

    public static int calculateTotalHours(int[] piles, int hourly) {
        int total = 0;
        for (int i = 0; i < piles.length; i++) {
            total += Math.ceil((double)(piles[i]) / (double)(hourly));
        }
        return total;
    }
}