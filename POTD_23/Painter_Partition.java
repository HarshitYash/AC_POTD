/*https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/*/

import java.util.Scanner;

public class Painter_Partition {
    boolean isPossible(int[] arr, int k, int maxAllowed){
        int painters = 1, time = 0;
        
        for(int i = 0 ; i < arr.length ; i++){
            if(time + arr[i] <= maxAllowed){
                time += arr[i];
            }else{
                painters++;
                time = arr[i];
            }
        }
        
        return (painters<=k);
    }
    public int minTime(int[] arr, int k) {
        int sum = 0, maxVal = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            maxVal = Math.max(maxVal, arr[i]);
        }
        int st = maxVal, end = sum, ans = -1;
        while(st <= end){
            int mid = st + (end - st)/2;
            
            if(isPossible(arr, k, mid)){
                ans = mid;
                end = mid - 1;
            }else{
                st = mid +1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Painter_Partition obj = new Painter_Partition();


        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();
        System.out.println(obj.minTime(arr, k));

        sc.close();
    }
}
