//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            System.out.println(new Solution().minJumps(arr));
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr) {
        // your code here
        if(arr.length <=1) return 0;
        if(arr[0]>=arr.length-1) return 1;
        if(arr[0]==0) return -1;
        
        int jump=1;
        int maxReach=arr[0];
        int step=arr[0];
        
        for(int i=1; i<arr.length; i++){
            if(i==arr.length -1) return jump;
            if(i>=arr.length-1) return jump+1;
            
            maxReach= Math.max(maxReach,i+arr[i]);
            step--;
            
            if(step==0){
                jump++;
                if(i>=maxReach) return -1;
                step=maxReach-i;
            }
        }
        return -1;
    }
}