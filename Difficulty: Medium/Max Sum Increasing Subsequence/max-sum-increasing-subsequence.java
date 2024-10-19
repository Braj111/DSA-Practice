//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n )  
	{  
	    //code here.
	    if(n==0) return 0;
	    int[] dp= new int[n];
	    
	    for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
        }
        
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i] && dp[i]<dp[j]+arr[i]){ //smaller & equal condition check
                    dp[i]=dp[j]+arr[i];
                }
            }
        }

	    return Arrays.stream(dp).max().getAsInt();
	    
	   // return sum(arr,n-1,0,Integer.MAX_VALUE);
	}


	//Without DP Solution
	
// 	public int sum(int arr[], int n, int sum, int prev){
// 	    if(n<0) return sum;
// 	    int take=0, notTake=0;
	    
// 	    if(sum==0){ //first element
// 	        int a = sum(arr,n-1,sum+arr[n],arr[n]); 
// 	        int b= sum(arr,n-1,sum,prev);
// 	        int k=Math.max(a,b);
// 	        return k;
// 	    }
	    
// 	    if(arr[n] < prev) take = sum(arr,n-1,sum+arr[n],arr[n]);
// 	    notTake= sum(arr,n-1,sum,prev);
	    
// 	    int s = Math.max(take,notTake);
// 	    return s;
// 	}
}