class Solution {
    public int maximumSum(int[] nums) {
        int maxPairSum = -1;
        int[] maxNumWithDigitSum = new int[100];
        for (int number : nums) {
            int sumOfDigits = 0;
            for (int tempNumber = number; tempNumber > 0; tempNumber /= 10) {
                sumOfDigits += tempNumber % 10;
            }
            if (maxNumWithDigitSum[sumOfDigits] > 0) {
                maxPairSum = Math.max(maxPairSum, maxNumWithDigitSum[sumOfDigits] + number);
            }
            maxNumWithDigitSum[sumOfDigits] = Math.max(maxNumWithDigitSum[sumOfDigits], number);
        }
        return maxPairSum;
    }
}