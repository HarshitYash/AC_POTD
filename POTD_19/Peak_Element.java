//https://leetcode.com/problems/find-peak-element/description/

import java.util.*;

public class Peak_Element {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int n = scanner.nextInt();
            
            if (n <= 0) {
                System.out.println("Array size must be greater than 0.");
                return;
            }
            
            int[] nums = new int[n];
            System.out.println("Enter the elements of the array:");
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            
            Peak_Element obj = new Peak_Element();
            int peakIndex = obj.findPeakElement(nums);
            
            System.out.println("Peak Element Index: " + peakIndex);
            System.out.println("Peak Element Value: " + nums[peakIndex]);
        }
    }
}
