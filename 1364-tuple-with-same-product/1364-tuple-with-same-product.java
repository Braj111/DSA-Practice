class Solution {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 1; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                int product = nums[i] * nums[j];
                countMap.merge(product, 1, Integer::sum);
            }
        }
      
        int answer = 0; 
        for(int frequency : countMap.values()) {
            answer += frequency * (frequency - 1) / 2;
        }
        return answer << 3; 
    }
}