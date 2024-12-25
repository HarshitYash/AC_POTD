//https://leetcode.com/problems/single-number/description/

import java.util.Scanner;

class Single_Number {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Single_Number num = new Single_Number();
        int result = num.singleNumber(nums);
        System.out.println("The single number is: " + result);

        sc.close();
    }
}