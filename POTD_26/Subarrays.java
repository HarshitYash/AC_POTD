//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/description/

import java.util.Scanner;

public class Subarrays { 
    public int countSubarrays(int[] nums, int bound) {
        int count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] > bound) {
                left = right + 1;
            }
            count += right - left + 1;
        }
        return count;
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return countSubarrays(nums, right) - countSubarrays(nums, left - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the left bound: ");
        int left = scanner.nextInt();
        
        System.out.print("Enter the right bound: ");
        int right = scanner.nextInt();

        Subarrays solution = new Subarrays();

        int result = solution.numSubarrayBoundedMax(nums, left, right);

        System.out.println("The number of valid subarrays is: " + result);
        
        scanner.close();
    }
}
