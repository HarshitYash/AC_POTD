//https://leetcode.com/problems/sort-colors/description/

import java.util.Scanner;

class Color_sort {
    public void sortColors(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j > 0 && (nums[j] < nums[j - 1])) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements : ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Color_sort scan = new Color_sort();
        scan.sortColors(nums);

        System.out.println("Sorted colors: ");
        for (int j = 0; j < n; j++) {
            System.out.print(nums[j] + " ");
        }
        sc.close();
    }
}