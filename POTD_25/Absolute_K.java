//https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/description/

import java.util.*;

class Absolute_K{
    public int countKDifference(int nums[], int k) {
        int size = nums.length;
        int count=0;
        if(size<=1)
            return 0;
        for (int i = 0; i < size-1; i++) {
            for (int j = i+1; j < size; j++) {
                if(Math.abs(nums[i]-nums[j]) == k){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int []mat = new int[size];
        for (int i = 0; i < size; i++) {
                mat[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Absolute_K obj = new Absolute_K();
        System.out.println(obj.countKDifference(mat, k));

        sc.close();
    }
}