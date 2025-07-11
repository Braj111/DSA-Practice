class Solution {
    static void multiply(int[][] mat1, int[][] mat2) {
        int x = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int y = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int z = mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int w = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];
        mat1[0][0] = x;
        mat1[0][1] = y;
        mat1[1][0] = z;
        mat1[1][1] = w;
    }
    static void matrixPower(int[][] mat1, int n) {
        if (n == 0 || n == 1) return;
        int[][] mat2 = {{1, 1}, {1, 0}};
        matrixPower(mat1, n / 2);
        multiply(mat1, mat1);
        if (n % 2 != 0) {
            multiply(mat1, mat2);
        }
    }
    static int nthFibonacci(int n) {
        if (n <= 1) return n;

        int[][] mat1 = {{1, 1}, {1, 0}};
        matrixPower(mat1, n - 1);

        return mat1[0][0];
    }
    static int countConsec(int n) {
        int total = 1 << n;
        int noConsec = nthFibonacci(n + 2);

        return total - noConsec;
    }
}
