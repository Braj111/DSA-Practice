//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends




class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int second=0;
        ArrayList<Integer> ans= new ArrayList<>();
        int curr=0;
        
        if(arr[0]==s){
            ans.add(1); ans.add(1);
            return ans;
        }
        
        if(s==0){
            for(int i=0; i<n; i++){
                if(arr[i]==0){
                    ans.add(i+1);
                    ans.add(i+1);
                    return ans;
                }
            }
            ans.add(-1); 
            return ans;
        }
        
        for(int i=0; i<n; i++){
            while(curr>s){
                curr-=arr[second];
                second+=1;
            }
            if(curr==s){
                ans.add(second+1);
                ans.add(i);
                return ans;
            }
            curr+=arr[i];
        }
        
        while(curr>s){
            curr-=arr[second];
            second+=1;
            
            if(curr==s){
                ans.add(second+1);
                ans.add(n);
                return ans;
            }
        }
        
        ans.add(-1); 
        return ans;
    }
}