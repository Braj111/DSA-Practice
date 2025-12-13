class Solution {
    public void swapDiagonal(int[][] mat) {
        // code here
        int size = mat.length;
        for (int i = 0; i < size; i++) {
            int temp = mat[i][i];
            mat[i][i] = mat[i][size - i - 1];
            mat[i][size - i - 1] = temp;
        }
    }
}