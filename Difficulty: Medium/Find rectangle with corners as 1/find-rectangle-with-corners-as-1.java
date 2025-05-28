class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here
         int rows = mat.length;
        int cols = mat[0].length;
        HashSet<String> seen = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int col1 = 0; col1 < cols - 1; col1++) {
                if (mat[i][col1] == 0) continue;

                for (int col2 = col1 + 1; col2 < cols; col2++) {
                    if (mat[i][col2] == 0) continue;
                    String key = col1 + "," + col2;
                    if (seen.contains(key)) {
                        return true;
                    }
                    seen.add(key);
                }
            }
        }
        return false;
    }
}