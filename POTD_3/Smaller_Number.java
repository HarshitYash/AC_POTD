//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/submissions/1486347897/

import java.util.Scanner;

class Smaller_Number {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] smaller = new int[nums.length];
        int count;
        for (int i = 0; i < nums.length; i++) {
            count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] > nums[j])
                    count++;
            }
            smaller[i] = count;
        }
        return smaller;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Smaller_Number solution = new Smaller_Number();
        int[] result = solution.smallerNumbersThanCurrent(nums);

        System.out.print("Result: ");
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}