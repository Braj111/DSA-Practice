class Solution {
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int low = 0, high = m - 1;
    
        int mini = -1000000000;
        while (low <= high) {
            int mid = (low + high) / 2;
            int maxRow = 0;
            for (int i = 1; i < n; ++i) {
                if (mat[i][mid] > mat[maxRow][mid])
                    maxRow = i;
            }
            int left = (mid > 0) ? 
                            mat[maxRow][mid - 1] : mini;
            int right = (mid + 1 < m) ? 
                            mat[maxRow][mid + 1] : mini;
            if (mat[maxRow][mid] >= left && 
                        mat[maxRow][mid] >= right) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(maxRow);
                res.add(mid);
                return res;
            }
            else if (right > mat[maxRow][mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        return res;
    }
}