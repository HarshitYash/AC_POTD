//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1

import java.io.*;
import java.util.*;

public class Allocated_Pages {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            int ans = findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
    public static int findPages(int[] arr, int k) {
        if (k > arr.length) return -1;

        int low = Arrays.stream(arr).max().getAsInt();
        int high = Arrays.stream(arr).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int students = countStudents(arr, mid);

            if (students > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static int countStudents(int[] arr, int pages) {
        int stu = 1;
        long page = 0;

        for (int i = 0; i < arr.length; i++) {
            if (page + arr[i] <= pages) {
                page += arr[i];
            } else {
                stu++;
                page = arr[i];
            }
        }

        return stu;
    }
}
