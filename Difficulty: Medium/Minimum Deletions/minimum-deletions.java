class Solution {
    static int minDeletions(String s) {
        // code here
         int n = s.length();
        int[] prev1 = new int[n];
        int[] curr = new int[n];
        int[] prev2 = new int[n];
        for (int l = 2; l <= n; l++) {
            for (int i = n - l; i >= 0; i--) {
                int j = i + l - 1;
                if (l == 2) {
                    curr[i] = (s.charAt(i) == s.charAt(j)) ? 0 : 1;
                } 
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        curr[i] = prev2[i + 1];
                    } 
                    else {
                        curr[i] = 1 + Math.min(prev1[i], prev1[i + 1]);
                    }
                }
            }
            prev2 = prev1.clone();
            prev1 = curr.clone();
        }
        return prev1[0];
    }
}