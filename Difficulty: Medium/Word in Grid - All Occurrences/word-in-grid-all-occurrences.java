class Solution {

    boolean search2D(char[][] grid, int row, int col, String word) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[row][col] != word.charAt(0))
            return false;

        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int dir = 0; dir < 8; dir++) {

            int currX = row + x[dir];
            int currY = col + y[dir];

            int k;

            for (k = 1; k < word.length(); k++) {

                if (currX < 0 || currX >= m ||
                    currY < 0 || currY >= n) {
                    break;
                }

                if (grid[currX][currY] != word.charAt(k)) {
                    break;
                }

                currX += x[dir];
                currY += y[dir];
            }

            if (k == word.length())
                return true;
        }

        return false;
    }

    public ArrayList<ArrayList<Integer>> searchWord(char[][] mat, String word) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

                if (search2D(mat, i, j, word)) {

                    ArrayList<Integer> coordinate = new ArrayList<>();

                    coordinate.add(i);
                    coordinate.add(j);

                    ans.add(coordinate);
                }
            }
        }

        return ans;
    }
}
