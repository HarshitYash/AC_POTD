//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

import java.util.*;

public class Min_Rotated {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[low]<=nums[mid]){
                min = Math.min(min,nums[low]);
                low=mid+1;
            }else{
                high=mid-1;
                min=Math.min(min,nums[mid]);
            }
        } 
    return min;
    }
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){

            System.err.println("Enter the size of the array: ");
            int n = scanner.nextInt();

            int[] arr = new int[n];
            System.out.println("Enter the elements of the rotated array:");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            Min_Rotated obj = new Min_Rotated();
            System.out.println("Minimum value : " + obj.findMin(arr));
            scanner.close();
        }
    }
}