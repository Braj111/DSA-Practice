class Solution {
    public int equalSumSpan(int[] a1, int[] a2) {
        // code here
        int n = a1.length;
        int maxLen = 0;
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        
        int prefixSum1 = 0, prefixSum2 = 0;
        
        for (int i = 0; i < n; i++) {
            prefixSum1 += a1[i];
            prefixSum2 += a2[i];
            
            int currentDiff = prefixSum1 - prefixSum2;
            if (currentDiff == 0) {
                maxLen = Math.max(maxLen, i + 1);
            }
            else if (diffMap.containsKey(currentDiff)) {
                maxLen = Math.max(maxLen, i - diffMap.get(currentDiff));
            } 
            else {
                diffMap.put(currentDiff, i);
            }
        }
        
        return maxLen;
    }
}