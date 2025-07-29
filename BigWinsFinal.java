import java.util.*;
import java.io.*;

public class BigWinsFinal {
    
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
    
    /**
     * Finds the maximum value of med(a[l,r]) - min(a[l,r]) across all subarrays
     * 
     * Approach: Try all possible subarrays O(n^2), for each subarray:
     * 1. Sort the subarray O(n log n)
     * 2. Find median at position ceil((k+1)/2) where k is subarray length
     * 3. Find minimum (first element after sorting)
     * 4. Calculate difference and track maximum
     * 
     * Time Complexity: O(n^3 log n)
     * Space Complexity: O(n)
     */
    public static int solve(int[] arr, int n) {
        int maxDiff = 0;
        
        // Try all possible subarrays
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                int len = r - l + 1;
                
                // Extract subarray
                int[] subarray = new int[len];
                for (int k = 0; k < len; k++) {
                    subarray[k] = arr[l + k];
                }
                
                // Sort to find median and minimum
                Arrays.sort(subarray);
                
                // Find median at position ceil((len+1)/2) in 1-indexed
                // Convert to 0-indexed: ceil((len+1)/2) - 1 = (len+2)/2 - 1
                int medianIndex = (len + 2) / 2 - 1;
                int median = subarray[medianIndex];
                
                // Minimum is first element after sorting
                int min = subarray[0];
                
                // Update maximum difference
                int diff = median - min;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        
        return maxDiff;
    }
}