//https://leetcode.com/problems/merge-sorted-array/

import java.util.*;

public class Merge_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements in nums1 : ");
        int size1 = sc.nextInt();
        int[] nums1 = new int[size1];

        System.out.print("Enter the number of actual elements in nums1: ");
        int m = sc.nextInt();

        System.out.println("Enter the first " + m + " sorted elements of nums1:");
        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.print("Enter the number of elements in nums2: ");
        int n = sc.nextInt();
        int[] nums2 = new int[n];

        System.out.println("Enter " + n + " sorted elements of nums2:");
        for (int i = 0; i < n; i++) {
            nums2[i] = sc.nextInt();
        }

        Merge_Array obj = new Merge_Array();
        obj.merge(nums1, m, nums2, n);

        System.out.println("Merged Array: " + Arrays.toString(nums1));

        sc.close();
    }
}
