//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.nCr(n, r));
            System.out.println("~");
        }

        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public int nCr(int n, int r) {
        if (r == 0 || n == r) return 1;
        double res = 0;
        for (int i = 0; i < r; i++) {
            res += Math.log(n-i) - Math.log(i+1);
        }
        return (int)Math.round(Math.exp(res));
    }
}