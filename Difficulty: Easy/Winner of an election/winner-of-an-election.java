//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String, Integer> hm= new HashMap<>();
        int max=1;
        String m=arr[0];
        
        for(int i=0; i<n; i++){
            hm.put(arr[i], 1+ hm.getOrDefault(arr[i],0));
        }
        for(int i=0; i<n; i++){
           if(hm.get(arr[i])>max){
                max=hm.get(arr[i]);
                m=arr[i];
            }
            if(hm.get(arr[i])==max && m.compareTo(arr[i])>0){
                max=hm.get(arr[i]);
                m=arr[i];
            }
        }
        
        String[] ans= new String[2];
        ans[0]=m; ans[1]=String.valueOf(max);
        return ans;
    }
}

