//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String s2 = br.readLine();

            Solution ob = new Solution();
            int ans = ob.editDistance(s1, s2);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s1, String s2) {
        // Code here
        int m=s1.length();
        int n=s2.length();
        
        int prev;
        int[] curr=new int[n+1];
        
        for (int j = 0; j <= n; j++) 
            curr[j] = j;

        for (int i = 1; i <= m; i++) {
            prev = curr[0];
            curr[0] = i;
            for (int j = 1; j <= n; j++) {
                int temp = curr[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = prev;
                else
                    curr[j] = 1 + Math.min(Math.min(curr[j - 1], prev), curr[j]);
                prev = temp;
            }
        }

        return curr[n];
    }
}