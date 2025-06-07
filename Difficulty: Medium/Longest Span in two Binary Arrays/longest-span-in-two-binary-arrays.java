
class Solution {
    public int longestCommonSum(int[] a1, int[] a2) {
        // Code here
        int n = a1.length;
        int res = 0;
        HashMap<Integer, Integer> diffMap = new HashMap<>();
        
        int sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < n; i++) {
            sum1 += a1[i];
            sum2 += a2[i];
            
            int currentDiff = sum1 - sum2;
            if (currentDiff == 0) {
                res = Math.max(res, i + 1);
            }
            else if (diffMap.containsKey(currentDiff)) {
                res = Math.max(res, i - diffMap.get(currentDiff));
            } 
            else {
                diffMap.put(currentDiff, i);
            }
        }
        
        return res;
    }
}