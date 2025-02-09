class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long res = 0;
        for (int i = 0; i < nums.length; ++i) {
            int difference = i - nums[i];
            res += i - countMap.getOrDefault(difference, 0);
            countMap.merge(difference, 1, Integer::sum);
        }
        return res; 
    }
}
