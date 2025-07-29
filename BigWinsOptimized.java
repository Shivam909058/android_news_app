import java.util.*;
import java.io.*;

public class BigWinsOptimized {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] input = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i]);
            }
            
            System.out.println(solve(arr, n));
        }
    }
    
    public static int solve(int[] arr, int n) {
        int maxDiff = 0;
        
        // Try all possible subarrays
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int len = r - l + 1;
                
                // Create a temporary array for this subarray
                int[] temp = new int[len];
                for (int k = 0; k < len; k++) {
                    temp[k] = arr[l + k];
                }
                
                // Sort to find median and min
                Arrays.sort(temp);
                
                // Find median and min
                int medianIndex = (len + 2) / 2 - 1;
                int median = temp[medianIndex];
                int min = temp[0];
                
                // Calculate difference
                int diff = median - min;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        
        return maxDiff;
    }
}