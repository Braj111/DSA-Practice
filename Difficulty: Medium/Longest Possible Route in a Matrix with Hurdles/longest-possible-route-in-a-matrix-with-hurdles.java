class Solution {
     static int dfs(int[][] mat, int i, int j, int x, int y) {
        int m = mat.length;
        int n = mat[0].length;
        
        
        if (i == x && j == y) {
            return 0;
        }
        
        
        if (i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 0) {
            return -1; 
        }
        
        
        mat[i][j] = 0;
        
        int maxPath = -1;
        
        
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        
        for (int k = 0; k < 4; k++) {
            int ni = i + row[k];
            int nj = j + col[k];
            
            int pathLength = dfs(mat, ni, nj, x, y);
            
            
            if (pathLength != -1) {
                maxPath = Math.max(maxPath, 1 + pathLength);
            }
        }
        
        
        mat[i][j] = 1;
        
        return maxPath;
    }
    
    static int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
        int m = mat.length;
        int n = mat[0].length;
        
        
        if (mat[xs][ys] == 0 || mat[xd][yd] == 0) {
            return -1;
        }
        
        return dfs(mat, xs, ys, xd, yd);
    }
}