class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int r = mat.length;
        int c = mat[0].length;
        int res = 0;
        for (int i = 0; i < r; i++)
        {
            boolean isOne = false; 
            for (int j = 0; j < c; j++)
            {
                if (mat[i][j] == 1)
                    isOne = true;
                else if (isOne)
                    res++;
            }
            isOne = false;

            for (int j = c - 1; j >= 0; j--)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }
        }
        for (int j = 0; j < c; j++)
        {
            boolean isOne = false; 

            for (int i = 0; i < r; i++)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }

            isOne = false;

            for (int i = r - 1; i >= 0; i--)
            {
                if (mat[i][j] == 1)
                    isOne = true;

                else if (isOne)
                    res++;
            }
        }

        return res;
    }
}