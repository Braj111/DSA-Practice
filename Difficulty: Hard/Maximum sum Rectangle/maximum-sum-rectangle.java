class Solution {
    int kadane(int[] temp) {
        int rows = temp.length;
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            currSum += temp[i];
            if (maxSum < currSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return maxSum;
    }
    public int maxRectSum(int mat[][]) {
        // code here
        int rows = mat.length;
        int cols = mat[0].length;

        int maxSum = Integer.MIN_VALUE;
        int[] temp = new int[rows];
        for (int left = 0; left < cols; left++) {
            for (int i = 0; i < rows; i++) {
                temp[i] = 0;
            }

            for (int right = left; right < cols; right++) {
                for (int row = 0; row < rows; row++) {
                    temp[row] += mat[row][right];
                }
                int sum = kadane(temp);
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
};