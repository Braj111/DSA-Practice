//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static String longestPalin(String str){
        // code here
        int n= str.length();
        boolean[][] dp=new boolean[n][n];
        
        int max=1;
        int start=0;
        
        //for length 1
        for(int j=0; j<n; j++){
            dp[j][j]=true;
        }
        
        //for length 2
        boolean flag=true;
        for(int j=0; j<n-1; j++){
            if(str.charAt(j)==str.charAt(j+1)){
                dp[j][j+1]=true;
                if(flag){
                    max=2;
                    start=j;
                    flag=false;
                }
            } 
            else dp[j][j+1]=false;
        }
        
        //for length 3 onwards
        for(int k=3; k<n+1; k++){
            for(int i=0; i<n-k+1; i++){
                int j=k+i-1;
                if(dp[i+1][j-1] && str.charAt(i)==str.charAt(j)){
                    
                    dp[i][j]=true;
                    if(k>max){
                        max=k; start=i;
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return str.substring(start,start+max);
        
    }
    
}