//{ Driver Code Starts
// Initial Template for Java

import java.math.*;
import java.util.*;

class Multiply {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            String b = sc.next();
            Solution g = new Solution();
            System.out.println(g.multiplyStrings(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String multiplyStrings(String s1, String s2) {
        // code here.
        int n1 = s1.length(), n2 = s2.length();
        if (n1 == 0 || n2 == 0) return "0";
        int nn = 1, mm = 1;
        if (s1.charAt(0) == '-')
            nn = -1;
        if (s2.charAt(0) == '-')
            mm = -1;
        int isNeg = nn * mm;
        int[] result = new int[n1 + n2];
        int i1 = 0;
        int i2 = 0;
        for (int i = n1 - 1; i >= 0; i--) {
            if (s1.charAt(i) == '-')
                continue;
            int carry = 0;
            int n1Digit = s1.charAt(i) - '0';
            i2 = 0;
            for (int j = n2 - 1; j >= 0; j--) {
                if (s2.charAt(j) == '-')
                    continue;
                int n2Digit = s2.charAt(j) - '0';
                int sum = n1Digit * n2Digit + result[i1 + i2] + carry;
                carry = sum / 10;
                result[i1 + i2] = sum % 10;
                
                i2++;
            }
            if (carry > 0)
                result[i1 + i2] += carry;
            
            i1++;
        }
        int i = result.length - 1;
        while (i >= 0 && result[i] == 0) i--;
        if (i == -1) return "0";
        String s = "";
        while (i >= 0) s += Integer.toString(result[i--]);
        if (isNeg == -1) s = "-" + s;
        
        return s;
    }
}