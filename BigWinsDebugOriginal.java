import java.util.*;
import java.io.*;

public class BigWinsDebugOriginal {
    
    public static void main(String[] args) throws IOException {
        int[] arr = {1, 4, 1, 5, 3, 3};
        int n = 6;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Result: " + solve(arr, n));
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
                int medianIndex = (len + 2) / 2 - 1;
                int median = subarray[medianIndex];
                
                // Find minimum (first element after sorting)
                int min = subarray[0];
                
                // Calculate difference
                int diff = median - min;
                
                if (diff > maxDiff) {
                    System.out.println("New max found: subarray [" + l + "," + r + "]: " + Arrays.toString(Arrays.copyOfRange(arr, l, r+1)) + " -> sorted: " + Arrays.toString(subarray) + " -> median=" + median + " (index " + medianIndex + "), min=" + min + ", diff=" + diff);
                    maxDiff = diff;
                }
            }
        }
        
        return maxDiff;
    }
}