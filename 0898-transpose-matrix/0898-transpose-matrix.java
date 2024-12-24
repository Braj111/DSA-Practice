class Solution {
    public int[][] transpose(int[][] matrix) {
        int r=matrix.length, c=matrix[0].length;
        int[][] arr = new int[c][r];
        for (int i=0; i<matrix.length; i++){
            for (int j=0; j<matrix[i].length; j++){
                arr[j][i]=matrix[i][j];
            }
        }
        return arr;
    }
}