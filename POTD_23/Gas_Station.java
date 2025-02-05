//https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/

import java.util.*;

public class Gas_Station {

    public boolean isPossible(double d, int[] stations, int k) {
        int requiredStations = 0;
        for (int i = 1; i < stations.length; i++) {
            double gap = stations[i] - stations[i - 1];
            requiredStations += (int) Math.ceil(gap / d) - 1;
        }
        return requiredStations <= k;
    }
    public double findSmallestMaxDist(int[] stations, int k) {
        double low = 0.0, high = stations[stations.length - 1] - stations[0];
        double precision = 1e-6;

        while (high - low > precision) {
            double mid = (low + high) / 2.0;

            if (isPossible(mid, stations, k)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return Math.round(high * 100.0) / 100.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] stations = new int[n];
        for (int i = 0; i < n; i++) {
            stations[i] = sc.nextInt();
        }
        
        int k = sc.nextInt();

        Gas_Station obj = new Gas_Station();
        System.out.printf("%.2f\n", obj.findSmallestMaxDist(stations, k));

        sc.close();
    }
}
