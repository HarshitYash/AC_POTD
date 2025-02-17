//https://leetcode.com/problems/container-with-most-water/

import java.util.Scanner;

class Container {
    public int maxArea(int[] height) {
        int l=0;
        int r=height.length-1;
        int max=0;
        while(l<r){
            int area = (r-l) * Math.min(height[l],height[r]);
            max = Math.max(max,area);
            if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        
        int[] height = new int[n];

        System.out.println("Enter the heights: ");
        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

    Container solution = new Container();

        int maxWater = solution.maxArea(height);

        System.out.println("Maximum water that can be contained: " + maxWater);
        
        sc.close();
    }
}