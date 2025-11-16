class Solution {
    public int numSub(String s) {
        final int MODULO = (int) 1e9 + 7;
        int totalCount = 0;
        int consecutiveOnes = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                consecutiveOnes++;
            } else {
                consecutiveOnes = 0;
            }
            totalCount = (totalCount + consecutiveOnes) % MODULO;
        }
      
        return totalCount;
    }
}