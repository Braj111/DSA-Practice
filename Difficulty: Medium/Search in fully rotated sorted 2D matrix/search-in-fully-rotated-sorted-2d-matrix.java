class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length;        
        int m = mat[0].length;     
        int low = 0, high = n * m - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / m;
            int col = mid % m;
            int midVal = mat[row][col];
            if (midVal == x) {
                return true;
            }
            int lowRow = low / m;
            int lowCol = low % m;
            int lowVal = mat[lowRow][lowCol];
            if (lowVal <= midVal) {
                if (lowVal <= x && x < midVal) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                int highRow = high / m;
                int highCol = high % m;
                int highVal = mat[highRow][highCol];
                if (midVal < x && x <= highVal) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}