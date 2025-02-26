class Solution {
    public int maxAbsoluteSum(int[] arr) {
        int minPoint = 0;
        int maxPoint = 0;
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;
            minPoint = Math.min(minPoint, prefixSum);
            maxPoint = Math.max(maxPoint, prefixSum);
        }
        return maxPoint - minPoint;
    }
}