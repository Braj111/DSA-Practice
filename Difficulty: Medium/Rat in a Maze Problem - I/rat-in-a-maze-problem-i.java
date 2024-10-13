//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> s= new ArrayList<String>();
        String str="";
        int n=mat.length;

        if(mat[0][0]==0) return s;
        sol(mat,s,str,0,0);
        
        return s;
    }
    
    
    public void sol(int[][] arr, ArrayList<String> s, String str, int i, int j){
        int n=arr.length;
        
        //check if this one is within boundry or not 
        if(i>=n || i<0 || j>=n || j<0 || arr[i][j]==0) return;
        
        if(i==n-1 && j==n-1){
            s.add(str);
            return;
        }
        
        arr[i][j]=0; //marking as visited
        
        sol(arr,s,str+'R',i,j+1);
        sol(arr,s,str+'L',i,j-1);
        sol(arr,s,str+'D',i+1,j);
        sol(arr,s,str+'U',i-1,j);
        
        arr[i][j]=1; //Backtrack
        
    }
}