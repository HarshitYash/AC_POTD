//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

import java.util.Scanner;

class Median_2Array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int []nums = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                nums[k++]=nums1[i++];
            }else if(nums1[i]>nums2[j]){
                nums[k++]=nums2[j++];
            }else{
                nums[k++]=nums1[i++];
                nums[k++]=nums2[j++];
            }
        }
        while(i<nums1.length){
            nums[k++]=nums1[i++];
        }
        while(j<nums2.length){
            nums[k++]=nums2[j++];
        }
        int mid=nums.length/2;
        if(nums.length%2 != 0){
            return (double)nums[mid];
        }
        return (nums[mid-1]+nums[mid])/2.0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Median_2Array obj = new Median_2Array();


        int n = sc.nextInt();
        int[] num1 = new int[n];

        for (int i = 0; i < n; i++) {
            num1[i] = sc.nextInt();
        }
        System.out.println();
        int m = sc.nextInt();
        int[] num2 = new int[m];

        for (int i = 0; i < m; i++) {
            num2[i] = sc.nextInt();
        }
        System.out.println();
        double median = obj.findMedianSortedArrays(num1, num2);
        System.out.printf("%.5f", median);
        System.out.println();
        sc.close();
    }
}