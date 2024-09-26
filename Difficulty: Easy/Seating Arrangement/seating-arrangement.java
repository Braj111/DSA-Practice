//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] arr){
        // code here
        if(n==0) return true;
        
        if(m==1){
            if(arr[0]==0 && n==1) return true;
            else return false;
        }
        
        int cnt=n;
        for(int i=0; i<m; i++){
            if(cnt==0) return true;
            if(arr[i]!=1){
            if(i!=0 && i!=m-1){
                if(arr[i-1]!=1 && arr[i+1]!=1){cnt--; arr[i]=1;}
            }
            else if(i==0 && arr[i+1]!=1) {cnt--; arr[i]=1;}
            else if(i==m-1 && arr[i-1]!=1) {cnt--; arr[i]=1;}
        }}
        if(cnt==0) return true;
        return false;

    }
}
        
