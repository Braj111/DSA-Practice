class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n * n + 1]; 
        int[] answer = new int[2];
        for (int[] row : grid) {
            for (int num : row) {
                count[num]++;
                if (count[num] == 2) {
                    answer[0] = num;
                }
            }
        }
        for (int i = 1; ; i++) {
            if (count[i] == 0) {
                answer[1] = i;
                return answer;
            }
        }
    }
}
