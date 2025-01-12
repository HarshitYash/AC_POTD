//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

import java.util.*;

public class Ship_Capacity {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the number of packages: ");
            int n = scanner.nextInt();

            int[] weights = new int[n];
            System.out.println("Enter the weights of the packages:");
            for (int i = 0; i < n; i++) {
                weights[i] = scanner.nextInt();
            }
            
            System.out.print("Enter the number of days: ");
            int days = scanner.nextInt();
            Ship_Capacity obj = new Ship_Capacity();
            int result = obj.shipWithinDays(weights, days);
            System.out.println("The minimum ship capacity required is: " + result);
        }
    }
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private static boolean check(int[] weights, int days, int capacity) {
        int current = 0, dayNeed = 1;

        for (int weight : weights) {
            if (current + weight > capacity) {
                dayNeed++;
                current = 0;
            }
            current += weight;

            if (dayNeed > days) {
                return false;
            }
        }
        return true;
    }
}
