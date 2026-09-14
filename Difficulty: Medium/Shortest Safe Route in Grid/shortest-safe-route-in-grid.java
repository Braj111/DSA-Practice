class Solution {
    static boolean isSafe(int[][] mat, int i, int j) {
           int r = mat.length;
           int c = mat[0].length;
           if (mat[i][j] != 1) return false;


           int[] rowDir = {-1, 1, 0, 0};
           int[] colDir = {0, 0, -1, 1};

           for (int k = 0; k < 4; k++) {
               int ni = i + rowDir[k];
               int nj = j + colDir[k];
               if (ni >= 0 && ni < r && nj >= 0 && nj < c && mat[ni][nj] == 0)
                   return false; 
           }
           return true;
       }
       static int shortestPath(int[][] mat) {
           int r = mat.length;
           int c = mat[0].length;

           int[] rowDir = {-1, 1, 0, 0};
           int[] colDir = {0, 0, -1, 1};
           Deque<int[]> q = new ArrayDeque<>(); 
           for (int i = 0; i < r; i++) {
               if (isSafe(mat, i, 0)) {
                   q.add(new int[]{i, 0, 1});
                   mat[i][0] = -1; 
               }
           }

           while (!q.isEmpty()) {
               int[] front = q.poll();
               int i = front[0], j = front[1], dist = front[2];
               if (j == c - 1) return dist;
               for (int k = 0; k < 4; k++) {
                   int ni = i + rowDir[k];
                   int nj = j + colDir[k];
                   if (ni >= 0 && ni < r && nj >= 0 && nj < c 
                                       && isSafe(mat, ni, nj)) {
                       q.add(new int[]{ni, nj, dist + 1});
                       mat[ni][nj] = -1; 
                   }
               }
           }
           return -1;
       }
}
