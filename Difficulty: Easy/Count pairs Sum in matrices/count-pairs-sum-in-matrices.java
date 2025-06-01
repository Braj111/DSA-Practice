class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int i = 0, j = (n*n -1);

        int count = 0;
        while (i < n * n && j >= 0) {
            int r1 = i/n, c1 = i%n;
            int r2 = j/n, c2 = j%n;
            int val = mat1[r1][c1] + mat2[r2][c2];

            if (val == x) {
                count++;
                i++;
                j--;
            } 
            else if (val < x) {
                i++;
            } 
            else {
                j--; 
            }
        }

        return count;
    }
}