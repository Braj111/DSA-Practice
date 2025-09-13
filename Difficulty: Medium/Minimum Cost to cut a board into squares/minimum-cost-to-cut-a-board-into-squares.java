class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // code here
        Arrays.sort(x);
        Arrays.sort(y); 

        int hCount = 1, vCount = 1; 
        int i = x.length - 1, j = y.length - 1; 
        int totalCost = 0;
        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                totalCost += x[i] * hCount; 
                vCount++;
                i--;
            } 
            else {
                totalCost += y[j] * vCount; 
                hCount++;
                j--;
            }
        }
        while (i >= 0) {
            totalCost += x[i] * hCount;
            vCount++;
            i--;
        }
        while (j >= 0) {
            totalCost += y[j] * vCount;
            hCount++;
            j--;
        }

        return totalCost;
    }
}
