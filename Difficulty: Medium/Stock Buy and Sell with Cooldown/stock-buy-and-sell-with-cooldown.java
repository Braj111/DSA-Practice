class Solution {
    public int maxProfit(int arr[]) {
        // Code here
         int n = arr.length;
        int[] ahead1 = new int[2];
        int[] ahead2 = new int[2];
        int[] curr = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            curr[1] = Math.max(-arr[i] + ahead1[0], ahead1[1]);
            curr[0] = Math.max(arr[i] + ahead2[1], ahead1[0]);
            ahead2 = ahead1.clone();
            ahead1 = curr.clone();
        }

        return ahead1[1];
    }
}
