import java.util.*;
import java.io.*;

public class BigWins {
    
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
                // Extract subarray from l to r (inclusive)
                int[] subarray = new int[r - l + 1];
                for (int k = 0; k < subarray.length; k++) {
                    subarray[k] = arr[l + k];
                }
                
                // Sort the subarray to find median
                Arrays.sort(subarray);
                
                // Find median (middle element)
                int len = subarray.length;
                int medianIndex = (len + 2) / 2 - 1; // ⌈(k+1)/2⌉ = (k+2)/2 for ceiling, then -1 for 0-indexed
                int median = subarray[medianIndex];
                
                // Find minimum (first element after sorting)
                int min = subarray[0];
                
                // Calculate difference
                int diff = median - min;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        
        return maxDiff;
    }
}