//https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/

import java.util.Scanner;

public class Min_Operation_By3 {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) {
                count++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Min_Operation_By3 solution = new Min_Operation_By3();

        int result = solution.minimumOperations(nums);
        System.out.println("Count of numbers not divisible by 3: " + result);

        sc.close();
    }
}
