class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
         Arrays.sort(prices);
        int n = prices.length;
        int minCost = 0;
        for (int i = 0; i < n; i++) {
            minCost += prices[i];
            n -= k;
        }
        int index = -1, maxCost = 0; 
        for (int i = prices.length - 1; i > index; i--) {
            maxCost += prices[i];
            index += k;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(minCost);
        result.add(maxCost);
        return result;
    }
}
