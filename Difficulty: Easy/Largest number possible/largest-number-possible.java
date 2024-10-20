//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int n, int s){
        // code here
        String str="";
        if(s==0 && n==1) return "0";
        else if(s==0) return "-1";
        for(int i=0; i<n; i++){
            int j=9;
            while(j>s) j--;
            str+=j;
            s=s-j;
        }
        if(s!=0) return "-1";
        return str;
        
        
    }
}