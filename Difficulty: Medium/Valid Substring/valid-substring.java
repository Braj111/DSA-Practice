//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static int findMaxLen(String s) {
        // code here
        int n= s.length();
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                if(!st.isEmpty() && s.charAt(st.peek())=='(') st.pop();
                else st.push(i);
            }
        }
        int res=0, top=n;
        while(!st.isEmpty()){
            int now=st.pop();
            
            res= Math.max(res,top-1-now);
            
            top=now;
        }
        return Math.max(res, top);
    }
};