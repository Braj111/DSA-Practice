//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maxXor(int[] arr) {
        // code here
         int res = 0, mask = 0;
        HashSet<Integer> s = new HashSet<>();
        for (int i = 30; i >= 0; i--) {
            mask |= (1 << i);

            for (int value : arr) {
                s.add(value & mask);
            }
            int cur = res | (1 << i);
            for (int prefix : s) {
                if (s.contains(cur ^ prefix)) {
                    res = cur;
                    break;
                }
            }
            s.clear();
        }
        return res;
    }
}