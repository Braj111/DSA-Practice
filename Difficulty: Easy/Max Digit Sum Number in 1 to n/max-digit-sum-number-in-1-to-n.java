class Solution {
    public int findMax(int n) {
        // code here
        String s = String.valueOf(n);
                int d = s.length();
                int totalSum = 0;

                for (char c : s.toCharArray())
                    totalSum += c - '0';
                int ans = n;
                int bestSum = totalSum;
                long p = 1;
                int suffixSum = 0;
                for (int i = d - 1; i >= 0; i--) {
                    int digit = s.charAt(i) - '0';
                    suffixSum += digit;
                    if (digit > 0) {
                        long cand = (n / (p * 10)) * (p * 10);
                        cand += (digit - 1) * p;
                        cand += p - 1;
                        int digitsRight = d - i - 1;
                        int curSum = totalSum - suffixSum
                                     + (digit - 1)
                                     + 9 * digitsRight;
                        if (curSum > bestSum
                            || (curSum == bestSum && cand > ans)) {
                            bestSum = curSum;
                            ans = (int)cand;
                        }
                    }
                    p *= 10;
                }

                return ans;
    }
}
