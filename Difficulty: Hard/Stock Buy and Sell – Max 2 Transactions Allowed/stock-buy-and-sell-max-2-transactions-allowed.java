//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxProfit(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    static int maxProfit(int[] prices)
    {
        int firstBuy = Integer.MIN_VALUE;  
        int firstSell = 0;      
        int secondBuy = Integer.MIN_VALUE; 
        int secondSell = 0;      
        for (int i = 0; i < prices.length; i++) {
            firstBuy = Math.max(firstBuy, -prices[i]);
            firstSell = Math.max(firstSell, firstBuy + prices[i]);
            secondBuy = Math.max(secondBuy, firstSell - prices[i]);
            secondSell = Math.max(secondSell, secondBuy + prices[i]);
        }
        return secondSell;
    }
}
