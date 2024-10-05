//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt();
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}


// } Driver Code Ends




// User function Template for Java

class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[][] dp=new long[N+1][sum+1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return counting(coins,N,sum,dp);
    }
    
    public long counting(int coins[], int N, int sum, long[][] dp){
        if(sum==0) return dp[N][sum]=1;
        if(N==0 || sum<0) return 0;
        
        if(dp[N][sum]!=-1) return dp[N][sum];
        
        return dp[N][sum]=counting(coins,N,sum-coins[N-1],dp)+counting(coins,N-1,sum,dp);
    }
}